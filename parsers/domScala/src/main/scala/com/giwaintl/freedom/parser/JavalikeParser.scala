package com.giwaintl.freedom.parser

import scala.util.parsing.combinator.{JavaTokenParsers, RegexParsers}

/**
 * @author Jorge A. Uveira
 * @author Michael Bergens
 */
object JavalikeParser extends JavaTokenParsers {
  def javaStr = stringLiteral

  def apply(input: String) = parseAll(stringLiteral, input)

  def fapply(input: String): String = parseAll(javaStr, input) match {
    case Success(tree, _) => tree//.toString
    case failure: NoSuccess => scala.sys.error(f"Bad syntax in >>$input<<\n${failure.msg}")
  }
}
