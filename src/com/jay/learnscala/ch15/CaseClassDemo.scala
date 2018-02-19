package com.jay.learnscala.ch15


sealed abstract class Expr

case class Val(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object CaseClassDemo {
  def main(args: Array[String]) {
    val v = Val("x")
    val op = BinOp("+", Number(1), v)
    println(v.name)
    println(op.left)
    println(op)
    println(op.right == Val("x"))
    println(op.copy(operator = "-"))
  }
}

