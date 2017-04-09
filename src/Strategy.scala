trait Strategy {
  def run() {
    method()
  }

  def method()
}

class DefaultStrategy extends Strategy {
  override def method() {
    println("Podstawowa strategia")
  }
}

class StrategyA extends Strategy {
  override def method() {
    println("Strategia A")
  }
}

class StrategyB extends Strategy {
  override def method() {
    println("Strategia B")
  }
}

class TestApp(var strategy: Strategy) {
  def doSomething() {
    strategy.run()
  }
}

object StrategyClient {
  var arg = "A"
  var strategy: Strategy = _
  arg match {
    case "A" => strategy = new StrategyA()
    case "B" => strategy = new StrategyB()
    case _ => strategy = new DefaultStrategy()
  }
  var testApp = new TestApp(strategy)
  testApp.doSomething()
  testApp.strategy = new StrategyB()
  testApp.doSomething()
}

