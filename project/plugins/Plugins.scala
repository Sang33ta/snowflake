import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val defaultProject = "com.twitter" % "standard-project" % "0.12.12"
  val sbtThrift = "com.twitter" % "sbt-thrift" % "2.0.1"
}
