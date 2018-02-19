package com.jay.learnscala.ch16

/**
  * Created by jay on 2018/2/18.
  */
object InsertSort {

  /**
    * 插入排序
    *
    * @param xs
    * @return
    */
  def isort(xs: List[Int]): List[Int] = {
    if (xs.isEmpty) {
      Nil
    } else {
      insert(xs.head, isort(xs.tail))
    }
  }

  def insert(x: Int, xs: List[Int]): List[Int] = {
    if (xs.isEmpty || x <= xs.head) {
      x :: xs
    } else {
      xs.head :: insert(x, xs.tail)
    }
  }
}
