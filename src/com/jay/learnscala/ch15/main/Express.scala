package com.jay.learnscala.ch15.main

/**
  * Created by jay on 2018/2/17.
  */
object Express extends App {
    val f = new ExprFormatter
    val e1 = BinaryOp("*", BinaryOp("/", NumberExpr(1), NumberExpr(2)), BinaryOp("+", ValExpr("x"), NumberExpr(1)))
    val e2 = BinaryOp("+", BinaryOp("/", ValExpr("x"), NumberExpr(2)), BinaryOp("/", NumberExpr(1.5), ValExpr("x")))
    val e3 = BinaryOp("/", e1, e2)

    def show(e: Expression) = println(f.format(e) + "\n\n")

    for (e <- Array(e1, e2, e3)) {
      show(e)
    }
}
