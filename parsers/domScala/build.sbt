// To build the distribution jar:
// sbt assembly
//
//then run as java -jar assembly.jar
name := "freeDomParser"

version := "1.0.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"

organization := "com.giwaintl.freedom.parser"

antlr4PackageName in Antlr4 := Some("com.giwaintl.freedom.grammars")

antlr4GenListener in Antlr4 := true // default: true

antlr4GenVisitor in Antlr4 := false // default: false

// https://github.com/ihji/sbt-antlr4
antlr4Settings

scalaVersion := "2.11.1"

