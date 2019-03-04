
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


// Release
import ReleaseTransformations._
import sbtrelease.{ Version, versionFormatError }

//releaseVersion     := { ver => Version(ver).map(_.withoutQualifier.string).getOrElse(versionFormatError("Error")) }

//releaseNextVersion := { ver => Version(ver).map(v =>
//    if (v.subversions.head < 99) v.bumpMinor else v.bumpMajor).map(_.asSnapshot.string).getOrElse(versionFormatError("Error")) }

releaseTagComment    := s"Releasing ${(version in ThisBuild).value}"
releaseCommitMessage := s"Setting version to ${(version in ThisBuild).value}"

releaseProcess := Seq[ReleaseStep](
    inquireVersions,
    //setReleaseVersion,
    //commitReleaseVersion,
    //tagRelease,
    //releaseStepCommand("docker:stage"),
    setNextVersion,
    //commitNextVersion
)

