package com.jay.learnscala.ch19

/**
  * created by zhoujie on 2018/02/20
  */
class Queue3[+T](
  private val leading: List[T],
  private val trailing: List[T]
) {
  private def mirror(): Queue3[T] = {
    if (leading.isEmpty) {
      new Queue3(trailing.reverse, Nil)
    } else {
      this
    }
  }

  def head(): T = mirror().leading.head

  def tail(): Queue3[T] = {
    val q = mirror()
    new Queue3[T](q.leading.tail, q.trailing)
  }

  /**
    * U is a super type
    * @param x
    * @tparam U
    * @return
    */
  def enqueue[U >: T](x: U): Queue3[U] = {
    new Queue3(leading, x :: trailing)
  }
}
