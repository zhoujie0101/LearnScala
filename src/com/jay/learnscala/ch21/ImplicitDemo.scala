package com.jay.learnscala.ch21

/**
  * created by zhoujie on 2018/02/20
  */
class ImplicitDemo {
  def maxListOrdering[T](element: List[T])(ordering: Ordering[T]): T = {
    element match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListOrdering(rest)(ordering)
        if (ordering.gt(x, maxRest)) x else maxRest
    }
  }

  def maxListImpParm[T](element: List[T])(implicit ordering: Ordering[T]): T = {
    element match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)(ordering)
        if (ordering.gt(x, maxRest)) x else maxRest
    }
  }

  def maxList[T](element: List[T])(implicit ordering: Ordering[T]): T = {
    element match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)
        if (ordering.gt(x, maxRest)) x else maxRest
    }
  }

  /**
    * use implicit[T](implicit t: T): t
    * @param element
    * @param ordering
    * @tparam T
    * @return
    */
  def maxList2[T](element: List[T])(implicit ordering: Ordering[T]): T = {
    element match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)
        if (implicitly[Ordering[T]].gt(x, maxRest)) x else maxRest
    }
  }

  def maxList3[T : Ordering](element: List[T]): T = {
    element match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)
        if (implicitly[Ordering[T]].gt(x, maxRest)) x else maxRest
    }
  }
}
