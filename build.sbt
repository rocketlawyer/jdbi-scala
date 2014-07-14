
name := "jdbi-scala"

organization := "com.gilt.jdbi-scala"

crossScalaVersions := Seq("2.11.1","2.10.4")

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.jdbi" % "jdbi" % "2.55",
  "junit" % "junit" % "4.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.0" % "test"
)

scalacOptions in Compile ++= Seq(
  "-encoding","UTF-8",
  "-target:jvm-1.7",
  "-deprecation",
  "-unchecked",
  "-explaintypes",
  "-feature",
  "-language:implicitConversions"
)

publishTo <<= version { (v: String) =>
  // val nexus = "https://oss.sonatype.org/"
  val nexus = "http://f1tst-linbld001/nexus"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "/content/repositories/snapshots")
  else
    Some("releases"  at nexus + "/content/repositories/releases")
    // Some("releases"  at nexus + "/service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

homepage := Some(url("https://github.com/gilt/jdbi-scala"))

pomExtra := (
  <scm>
    <url>git@github.com:gilt/jdbi-scala.git</url>
    <connection>scm:git:git@github.com:gilt/jdbi-scala.git</connection>
  </scm>
  <developers>
    <developer>
      <id>kscaldef</id>
      <name>Kevin Scaldeferri</name>
      <url>https://github.com/kscaldef</url>
    </developer>
  </developers>
)

