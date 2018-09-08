
name := "Programming In Scala"

scalaVersion := "2.12.4"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint")

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.5",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.5" % "test",
  "org.specs2" %% "specs2-core" % "4.0.2" % "test",
  "org.scala-lang.modules" %% "scala-swing" % "2.0.3",
  "org.scala-lang.modules" %% "scala-xml" % "1.1.0",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.0"
)