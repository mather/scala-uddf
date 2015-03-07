import ScalaxbKeys._

lazy val commonSettings = Seq(
  organization  := "com.github.mather",
  scalaVersion  := "2.11.5"
)

lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
lazy val dispatchV = "0.11.2"
lazy val dispatch = "net.databinder.dispatch" %% "dispatch-core" % dispatchV
lazy val specs2 = "org.specs2" %% "specs2-core" % "3.0" % "test"

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name          := "uddf",
    libraryDependencies ++= Seq(dispatch, specs2),
    libraryDependencies ++= {
      if (scalaVersion.value startsWith "2.11") Seq(scalaXml, scalaParser)
      else Seq()
    },
    resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
  ).
  settings(scalaxbSettings: _*).
  settings(
    sourceGenerators in Compile += (scalaxb in Compile).taskValue,
    dispatchVersion in (Compile, scalaxb) := dispatchV,
    async in (Compile, scalaxb)           := true,
    packageName in (Compile, scalaxb)     := "com.github.mather.uddf"
    // packageNames in (Compile, scalaxb)    := Map(uri("http://schemas.microsoft.com/2003/10/Serialization/") -> "microsoft.serialization"),
    // logLevel in (Compile, scalaxb) := Level.Debug
  )
