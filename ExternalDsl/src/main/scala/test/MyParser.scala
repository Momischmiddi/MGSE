package test

import scala.util.parsing.combinator.RegexParsers

class MyParser extends RegexParsers {

  def floatingPointNumber: Parser[String] = {
    """-?(\d+(\.\d*)?|\d*\.\d+)([eE][+-]?\d+)?[fFdD]?""".r
  }
}
