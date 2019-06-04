package test
import scala.util.parsing.combinator.RegexParsers

object Test extends MyParser {

  def main(args: Array[String]): Unit = {


    var result = parseAll(floatingPointNumber, "a")
    println(result)
  }


}