package com.jay.learnscala.ch12

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jay on 2018/2/16.
  */
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]()

  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit = buf += x
}
