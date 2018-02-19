package com.jay.learnscala.ch12

/**
  * Created by jay on 2018/2/16.
  */
object Main {
  def main(args: Array[String]) = {
    val queue = new BasicIntQueue with Incrementing with Filtering
    queue.put(-1)
    queue.put(0)
    queue.put(1)
    println(queue.get())
    println(queue.get())
  }
}
