
name := "jdbi-scala"

organization := "com.gilt.jdbi-scala"

crossScalaVersions := Seq("2.11.7","2.10.4")

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.jdbi" % "jdbi" % "2.63",
  "org.scalatest" %% "scalatest" % "2.2.5" % Test
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
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "/content/repositories/snapshots")
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

