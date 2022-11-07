name := """scala-interview"""

organization := "fr.canal"

lazy val `scala-interview` = (project in file("."))


libraryDependencies ++= Seq(
"org.scalatest" %% "scalatest" % "3.1.1",
  "com.typesafe.play" %% "play-json" % "2.9.2"
)