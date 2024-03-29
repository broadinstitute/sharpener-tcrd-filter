organization := "io.swagger"
name := "scalatra-sample"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.4"

mainClass in assembly := Some("JettyMain")

val ScalatraVersion = "2.6.2"
val sttpVersion = "1.6.6"

libraryDependencies ++= Seq(
  "org.scalatra"      %% "scalatra"             % ScalatraVersion,
  "org.scalatra"      %% "scalatra-swagger"     % ScalatraVersion,
  "org.scalatra"      %% "scalatra-scalatest"   % ScalatraVersion % Test,
  "org.json4s"        %% "json4s-jackson"       % "3.5.0",
  "org.eclipse.jetty" %  "jetty-server"         % "9.4.8.v20171121",
  "org.eclipse.jetty" %  "jetty-webapp"         % "9.4.8.v20171121",
  "javax.servlet"     %  "javax.servlet-api"    % "3.1.0",
  "ch.qos.logback"    %  "logback-classic"      % "1.2.3" % Provided,
  "com.softwaremill.sttp" %% "core" % sttpVersion,
  "com.softwaremill.sttp" %% "circe" % sttpVersion,
  "io.circe" %% "circe-generic" % "0.11.1"
)

enablePlugins(JettyPlugin)