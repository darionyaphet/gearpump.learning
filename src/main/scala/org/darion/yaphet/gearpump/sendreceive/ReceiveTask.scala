package org.darion.yaphet.gearpump.sendreceive

import io.gearpump.Message
import io.gearpump.cluster.UserConfig
import io.gearpump.streaming.task.{Task, TaskContext}

/**
  * Created by darion.johannes.yaphet on 16/3/21.
  */
class ReceiveTask(context: TaskContext, conf: UserConfig) extends Task(context, conf) {
  override def onNext(message: Message): Unit = {
    LOG.info(s"Receive : ${message.msg}")
  }
}
