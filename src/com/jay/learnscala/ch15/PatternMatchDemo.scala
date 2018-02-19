package com.jay.learnscala.ch15

/**
  * Created by jay on 2018/2/17.
  */
object PatternMatchDemo {
  def main(args: Array[String]) {
    println(constructorPatternMatch(UnOp("-", UnOp("-", Val("x")))))

    constructorPatternMatch2(BinOp("+", Number(1), Number(2)))

    constructorPatternMatch3(UnOp("-", Val("x")))

    variablePatternMatch(UnOp("abs", UnOp("abs", Val("1"))))

    describe(Val("x"))
  }

  def constructorPatternMatch(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }

  def constructorPatternMatch2(expr: Expr): Unit = expr match {
    case BinOp(op, left, right) => println(expr + " is a binary operation")
    case _ =>
  }

  def constructorPatternMatch3(expr: Expr) = expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operation")
    case _ => println("It's something else")
  }

  def constantPatternMatch(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "somehting else"
  }

  def sequencePatternMatch(expr: Any) = expr match {
    case List(0, _, _) => println("found it")
    case _ =>
  }

  def sequencePatternMatch2(expr: Any) = expr match {
    case List(0, _*) => println("found it")
    case _ =>
  }

  def tuplePatternMatch(expr: Any) = expr match {
    case (a, b, c) => println("matched " + a + b + c)
    case _ =>
  }

  def typedPatternMatch(x: Any) = x match {
    case s: String => s.length
//      if (x.isInstanceOf[String]) {
//        val sx = x.asInstanceOf[String]
//      }
    case m: Map[_, _] => m.size
    case _ => -1
  }

  def variablePatternMatch(expr: Any) = expr match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>
  }

  def patternGuard(e: Expr) = e match {
    case BinOp("+", x, y) if x == y =>
      BinOp("*", x, Number(2))
    case _ => e
  }

  def describe(e: Expr): String = e match {
    case Number(_) => "a number"
    case Val(_) => "a Val"
  }
}
