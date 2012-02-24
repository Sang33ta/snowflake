import com.twitter.service.snowflake.{SnowflakeConfig, ReporterConfig}
import com.twitter.logging.config.{LoggerConfig, FileHandlerConfig}
import com.twitter.logging.Level
import com.twitter.zookeeper.ZookeeperClientConfig
import java.net.InetAddress

new SnowflakeConfig {
  serverPort = 7609
  datacenterId = 0
  workerIdMap = Map(0 -> InetAddress.getLocalHost.getHostName)
  adminPort = 9990
  adminBacklog = 100
  workerIdZkPath = "/snowflake-servers"
  skipSanityChecks = false
  startupSleepMs = 10000
  thriftServerThreads = 2

  zookeeperClientConfig = new ZookeeperClientConfig {
    hostList = "localhost"
  }

  reporterConfig = new ReporterConfig {
    scribeCategory = "snowflake"
    scribeHost = "localhost"
    scribePort = 1463
    scribeSocketTimeout = 5000
    flushQueueLimit = 100000
  }

  loggers = new LoggerConfig {
    handlers = new FileHandlerConfig {
      level = Level.TRACE
      filename = "snowflake.log"
    }
  }
}