package com.jay.learnscala.ch18

/**
  * Created by jay on 2018/2/19.
  */
object MySimulation extends CircuitSimulation {
  override def InverterDelay: Int = 1

  override def AndGateDelay: Int = 3

  override def OrGateDelay: Int = 5

  def main(args: Array[String]) {
    val input1, input2, sum, carry = new Wire

    probe("sum", sum)

    probe("carry", carry)

    halfAdder(input1, input2, sum, carry)

    input1 setSignal true

    run()

    input2 setSignal true

    run()
  }
}
