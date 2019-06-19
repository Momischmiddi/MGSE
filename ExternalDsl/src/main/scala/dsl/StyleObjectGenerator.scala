package dsl

class StyleObjectGenerator extends StyleParser {

  def generate(dslFileContent: String) = {
    val result = parseAll(styleParser, dslFileContent)

    result.get
  }

}