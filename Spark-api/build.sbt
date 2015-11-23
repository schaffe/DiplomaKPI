import AssemblyKeys._

assemblySettings

name := "movielens-als"

version := "0.1"

scalaVersion := "2.11.7"

libraryDependencies += "org.apache.spark" % "spark-mllib_2.10" % "1.5.2" % "provided"
