package com.jay.learnscala.ch10

import Element.elem

/**
  * Created by jay on 2018/2/16.
  */
abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
//    new ArrayElement(this.contents ++ that.contents)
  }

  /*
  def beside(that: Element): Element = {
    val contents = new Array[String](this.contents.length)
    //for (i <- 0 until this.contents.indices) {
    for (i <- 0 until this.contents.length) {
      contents(i) = this.contents(i) + that.contents(i)
    }
    new ArrayElement(contents)
  }
  */

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2
    )
//    new ArrayElement(
//      for ((line1, line2) <- this.contents zip that.contents)
//        yield line1 + line2
//    )
  }

  def widen(w: Int): Element = {
    if (w <= this.width) this
    else {
      val left = elem(' ', (w - this.width) / 2, this.height)
      val right = elem(' ', w - this.width - left.width, this.height)
      left beside this beside right
    }
  }

  def heighten(h: Int): Element = {
    if (h <= this.height) this
    else {
      val top = elem(' ', this.width, (h - this.height) / 2)
      val bottom = elem(' ', this.width, h - this.height - top.height)
      top above this above bottom
    }
  }

  override def toString: String = this.contents mkString "\n"
}

object Element {

  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    val contents = Array(s)

    override def height: Int = 1

    override def width: Int = s.length
  }

  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int) extends Element {
    private val line: String = ch.toString * width

    override def contents: Array[String] = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = {
    new ArrayElement(contents)
  }

  def elem(ch: Char, width: Int, height: Int): Element = {
    new UniformElement(ch, width, height)
  }

  def elem(line: String): Element = {
    new LineElement(line)
  }

  def main(args: Array[String]): Unit = {
    println(elem(Array("one", "two")) above elem(Array("three")))
  }
}
