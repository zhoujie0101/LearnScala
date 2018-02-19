package com.jay.learnscala.ch12

/**
  * Created by jay on 2018/2/16.
  */
trait Doubling extends IntQueue{
  abstract override def put(x: Int) = {
    super.put(x * 2)
  }
}
