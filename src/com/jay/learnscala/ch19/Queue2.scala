package com.jay.learnscala.ch19

/**
  * created by zhoujie on 2018/02/20
  */
class Queue2[T] private (
  private val leading: List[T],
  private val trailing: List[T]
) {
  private def mirror(): Queue2[T] = {
    if (leading.isEmpty) {
      new Queue2(trailing.reverse, Nil)
    } else {
      this
    }
  }

  def head(): T = mirror().leading.head

  def tail(): Queue2[T] = {
    val q = mirror()
    new Queue2[T](q.leading.tail, q.trailing)
  }

  def enqueue(x: T): Queue2[T] = {
    new Queue2(leading, x :: trailing)
  }
}

object Queue2 {
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)

  def main(args: Array[String]): Unit = {

  }
}
