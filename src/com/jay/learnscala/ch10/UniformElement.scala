package com.jay.learnscala.ch10

/**
  * Created by jay on 2018/2/16.
  */
class UniformElement(
  ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  override def contents: Array[String] = Array.fill(height)(line)
}

object UniformElement {

  def main(args: Array[String]): Unit = {
    val e: UniformElement = new UniformElement('x', 2, 3)
    println(e.height)
    println(e.width)
  }
}
