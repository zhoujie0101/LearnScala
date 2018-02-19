package com.jay.learnscala.ch10

/**
  * Created by jay on 2018/2/16.
  */
class LineElement(s: String) extends Element {
  override def contents: Array[String] = Array(s)

  override def height: Int = 1
  override def width: Int = s.length
}
