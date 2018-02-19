package com.jay.learnscala.ch10

/**
  * Created by jay on 2018/2/16.
  */
class ArrayElement2(conts: Array[String]) extends Element {
  override def contents: Array[String] = conts
  //val contents: Array[String] = conts  //it's also ok
}
