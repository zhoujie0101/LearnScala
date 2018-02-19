package com.jay.learnscala.ch12

/**
  * Created by jay on 2018/2/16.
  */
trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}
