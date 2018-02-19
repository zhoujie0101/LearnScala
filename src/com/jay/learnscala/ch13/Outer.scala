package com.jay.learnscala.ch13

/**
  * Created by jay on 2018/2/16.
  */
class Outer {
  class Inner {
    private def f() = {
      println("f")
    }
    class InnerMost {
      f()
    }
  }

//  (new Inner).f()  //error
}
