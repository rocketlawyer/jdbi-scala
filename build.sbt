
name := "jdbi-scala"

organization := "com.gilt.jdbi-scala"

crossScalaVersions := Seq("2.10.2","2.9.3","2.9.2", "2.9.1")

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.jdbi" % "jdbi" % "2.51",
  "junit" % "junit" % "4.11" % "test",
  "org.scalatest" %% "scalatest" % "1.9.2" % "test"
)

resolvers ++= Seq(
  "Sonatype.org Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype.org Releases" at "http://oss.sonatype.org/service/local/staging/deploy/maven2"
)

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "/service/local/staging/deploy/maven2")
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

