package com.giwaintl.freedom.parser

import scala.util.parsing.combinator.syntactical._

sealed abstract class FreeDomTree

/** *
  * References:
  *
  * <ul>
  * <li><a href="http://www.codecommit.com/blog/scala/formal-language-processing-in-scala">Formal language processing
  * in Scala</a></li>
  * <li><a href="http://debasishg.blogspot.com/2008/04/external-dsls-made-easy-with-scala.html">External DSLs easy with Scala</li>
  * </ul>
  * @author Jorge A. Uveira
  * @see scala.collections.Seq
  */
object DomGrammar extends StandardTokenParsers {
  lexical.delimiters ++= List("{", "}" )
}
