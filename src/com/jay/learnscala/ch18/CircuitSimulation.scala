package com.jay.learnscala.ch18

/**
  * Created by jay on 2018/2/19.
  */
abstract class CircuitSimulation extends BasicCircuitSimulation {
  /**
    * 半加器
    * @param a
    * @param b
    * @param s
    * @param c
    */
  def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire): Unit = {
    val  d, e = new Wire
    orGate(a, b, d)
    andGate(a, b, c)
    inverter(c, e)
    andGate(d, e, s)
  }

  /**
    * 全加器
    * @param a
    * @param b
    * @param cin
    * @param sum
    * @param cout
    */
  def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire): Unit = {
    val s, c1, c2 = new Wire
    halfAdder(a, cin, s, c1)
    halfAdder(b, s, sum, c2)
    orGate(c1, c2, cout)
  }
}
