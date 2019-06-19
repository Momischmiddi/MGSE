package dsl

class MovieObjectGenerator extends MovieParser {

  def generate(dslFileContent: String) = {
    parseAll(movieParser, dslFileContent).get
  }

}