package com.giwaintl.freedom.parser

/**
 * @author Jorge A. Uveira
 */
object Main extends App {
  val appName = "the Parser"
  println(f"Parser started @$executionStart%d,\nargs[${args.length}]: >>>${args mkString ", "}<<<")
  if(args.length > 0) {
    /*
    val s = JavalikeParser(args(0))
    println(f"Result>>$s<<")
    println (s.get)
    println(s.get.charAt(0))
    */
    val lx = new HelloLexer(args(0))
  }
}
