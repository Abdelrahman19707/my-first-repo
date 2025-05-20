name := "scala-project"

version := "0.1"

scalaVersion := "3.4.1"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.10.6",
  "io.circe" %% "circe-core" % "0.14.13",
  "io.circe" %% "circe-generic" % "0.14.13",
  "io.circe" %% "circe-parser" % "0.14.13"
)
