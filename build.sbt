name := "Sbtassignment"

version := "0.1"

scalaVersion := "2.12.12"
lazy val common = project.in(file("common"))
  .settings(
    libraryDependencies ++= Seq(
      "io.github.embeddedkafka" %% "embedded-kafka" % "2.8.1" % Test,
      "org.json4s" %% "json4s-native" % "4.0.2",
      "org.scalactic" %% "scalactic" % "3.2.9",
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.46" % Test,
    )
  )
lazy val actor = project.in(file("actor"))
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream" % "2.6.17",
      "com.typesafe.akka" %% "akka-actor" % "2.6.17",
      "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.17",
      "com.typesafe.akka" %% "akka-persistence-testkit" % "2.6.17" % Test,
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.17" % Test,
    )
  ).dependsOn(common)
lazy val root = project.in(file(".")).aggregate(common, actor)


