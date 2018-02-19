package com.jay.learnscala.ch16

/**
  * Created by jay on 2018/2/18.
  */
object InsertSortUsingPatternMatch {

  /**
    * 插入排序
    *
    * @param xs
    * @return
    */
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insert(x, isort(xs1))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }
}
