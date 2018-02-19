package com.jay.learnscala.ch16

/**
  * Created by jay on 2018/2/18.
  */
object MergeSort {
  /**
    * 归并排序
    * @param less 比较函数
    * @param xs
    * @tparam T
    * @return
    */
  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(ys1, xs)
    }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

  def main(args: Array[String]) {
    println(msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3)))
  }
}
