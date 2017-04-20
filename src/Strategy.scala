class Parser {
  def parse() {
    println("Domyslny parser")
  }

  def chooseStrategy(filename: String): Parser = {
    val extension = filename.split(".")(1)

    extension match {
      case "json" => return new JsonParser()
      case "cvs" => return new CVSParser()
      case _ => return new Parser()
    }
  }
}

class JsonParser extends Parser {
  override def parse() {
    println("Parsowanie jsona")
  }
}

class CVSParser extends Parser {
  override def parse() {
    println("Parsowanie cvs")
  }
}

object Application {
  def main(args: Array[String]) = {
    val filename = args(0)
    val parser = new Parser().chooseStrategy(filename)
    parser.parse()
  }
}

