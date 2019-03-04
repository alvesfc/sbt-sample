
ThisBuild / scalaVersion := "2.12.8"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

lazy val root = (project in file("."))
  .settings(
    name := "sbt-sample",
    organization := "com.gympass", 
    hello := { println("Hello!") },
    libraryDependencies += scalaTest % Test,
)

enablePlugins(JavaAppPackaging)


lazy val hello = taskKey[Unit]("An example task")

