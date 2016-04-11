package org.darion.yaphet.gearpump.sendreceive

import io.gearpump.cluster.client.ClientContext
import io.gearpump.util.AkkaApp

/**
  * Created by darion.johannes.yaphet on 16/3/18.
  */
object SendReceiveMain extends AkkaApp {

  override def main(akkaConf: Config, args: Array[String]) {
    val cluster = ClientContext()
  }

  override def help: Unit = {

  }
}
