package com.jay.learnscala.ch23

/**
  * created by zhoujie on 2018/02/21
  */
object ForDemo {

  def map[A, B](xs: List[A], f: A => B): List[B] = {
    for (x <- xs) yield f(x)
  }

  def flatMap[A, B](xs: List[A], f: A => List[B]): List[B] = {
    for (x <- xs; y <- f(x)) yield y
  }

  def filter[A](xs: List[A], p: A => Boolean): List[A] = {
    for (x <- xs; if p(x)) yield x
  }

  def main(args: Array[String]): Unit = {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    val result1 = persons.filter(p => !p.isMale)
      .flatMap(p => p.children.map(c => (p.name, c.name)))
    println(result1)

    val result2 = persons.withFilter(p => !p.isMale)
      .flatMap(p => p.children.map(c => (p.name, c.name)))
    println(result2)

    val result3 = for (p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name)
    println(result3)
  }
}
