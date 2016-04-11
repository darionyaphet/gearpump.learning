package org.darion.yaphet.gearpump.sendreceive

import java.util.concurrent.TimeUnit

import io.gearpump.Message
import io.gearpump.cluster.UserConfig
import io.gearpump.streaming.task.{Task, TaskContext}

/**
  * Created by darion.johannes.yaphet on 16/3/18.
  */
class SendTask(taskContext: TaskContext, conf: UserConfig) extends Task(taskContext, conf) {

  private val LINE = "A quick brown fox jump over the lazy dog"

  override def onNext(message: Message): Unit = {
    LINE.split(" ").foreach { token =>
      LOG.info(s"Send : ${token}")
      taskContext.output(new Message(token, System.currentTimeMillis()))
    }

    import scala.concurrent.duration._
    taskContext.scheduleOnce(Duration(100, TimeUnit.MILLISECONDS))
    (self ! Message("continue", System.currentTimeMillis()))
  }
}
