package dsl

import model.{ButtonStyle, MovieDescriptionStyle, MovieInformationStyle, Style}
import scala.util.parsing.combinator.RegexParsers

class StyleParser extends RegexParsers {

  def styleParser: Parser[Style] =
    "Style:" ~
      "Buttonstyle:" ~ buttonStyle ~
      "Movieinformationstyle:" ~ movieInformationStyle ~
      "Moviedescriptionstyle:" ~ movieDescriptionStyle ^^ {
      case _ ~ buttonStyle ~ _ ~ movieInformationStyle ~ _ ~ movieDescriptionStyle =>
        Style(buttonStyle, movieInformationStyle, movieDescriptionStyle)
    }

  def buttonStyle: Parser[ButtonStyle] =
    "Font-style:" ~ fontStyle ~
      "Font-name:" ~ fontName ~
      "Font-size:" ~ integer ~
      "Border-color:" ~ color ~
      "Border-width:" ~ integer ~
      "X-size:" ~ integer ~
      "Y-size:" ~ integer ^^ {
      case _ ~ bfst ~ _ ~ bfna ~ _ ~ bfsi ~ _ ~ bbco ~ _ ~ bbwi ~ _ ~ bxs ~ _ ~ bys =>
        ButtonStyle(bfst, bfna, bfsi, bbco, bbwi, bxs, bys)
    }

  def movieInformationStyle: Parser[MovieInformationStyle] =
    "Font-style:" ~ fontStyle ~
      "Font-name:" ~ fontName ~
      "Font-size:" ~ integer ^^ {
      case _ ~ mifst ~ _ ~ mifna ~ _ ~ mifsi =>
        MovieInformationStyle(mifst, mifna, mifsi)
    }

  def movieDescriptionStyle: Parser[MovieDescriptionStyle] =
    "Font-style:" ~ fontStyle ~
      "Font-name:" ~ fontName ~
      "Font-size:" ~ integer ^^ {
      case _ ~ mdfst ~ _ ~ mdfna ~ _ ~ mdfsi =>
        MovieDescriptionStyle(mdfst, mdfna, mdfsi)
    }

  private def color: Parser[String] =
    """Red""" | """Black""" | """Green""" | """Yellow""" | """Blue"""

  private def fontName: Parser[String] =
    """Arial""" | """Courier""" | """TimesRoman"""

  private def fontStyle: Parser[String] =
    """Italic""" | """Bold""" | """Plain"""

  private def integer: Parser[Int] =
    """\d+""".r ^^ (_.toInt)
}