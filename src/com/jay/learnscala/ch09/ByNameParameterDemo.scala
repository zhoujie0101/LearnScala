package com.jay.learnscala.ch09

/**
  * Created by jay on 2018/2/16.
  * 传名参数
  */
object ByNameParameterDemo {
  var assertionEnabled = true

  def myAssert(predicate: () => Boolean): Unit = {
    if (assertionEnabled && !predicate()) {
      throw new AssertionError
    }
  }

  def byNameAssert(predicate: => Boolean): Unit = {
    if (assertionEnabled && !predicate) {
      throw new AssertionError
    }
  }

  def main(args: Array[String]): Unit = {
    myAssert(() => 5 > 3)
//    myAssert(5 > 3)  compile error

    byNameAssert(5 > 3)
  }
}
