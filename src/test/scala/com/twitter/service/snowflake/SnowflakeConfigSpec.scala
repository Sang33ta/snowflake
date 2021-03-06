package com.twitter.service.snowflake

import com.twitter.io.TempFile
import com.twitter.logging.Logger
import com.twitter.util.Eval
import java.io.{File, FilenameFilter}
import org.specs._

class SnowflakeConfigSpec extends Specification {

  "SnowflakeConfig" should {
    "properly extract the worker id" in {
      // new SnowflakeConfig {
      //      workerIdMap = Map
      //    }
    }
  }

  "config" should {
    "validate" in {
      val eval = new Eval
      val configFiles = Seq(
        "development.scala",
         "development2.scala",
         "test.scala"
      ) map {s:String => new File("snowflake/config/" + s) }

      for (file <- configFiles) {
        println("validating " + file.getName)
        val config = eval[SnowflakeConfig](file)
        config must notBeNull
        config.validate()
      }
    }
  }
}