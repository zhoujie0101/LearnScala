package com.jay.learnscala.ch15.main

import com.jay.learnscala.ch10.Element
import com.jay.learnscala.ch10.Element.elem
import com.jay.learnscala.ch15._

/**
  * Created by jay on 2018/2/17.
  */
class ExprFormatter {
  private val opGroups = Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!+"),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
    )

  private val precedence = {
    val assocs =
      for {
        i <- 0 until opGroups.length
        op <- opGroups(i)
      } yield op -> i
    assocs.toMap
  }

  private val unaryPrecedence = opGroups.length
  private val fractionPrecedence = -1

  private def format(e: Expression, enclPrec: Int): Element = {
    e match {
      case ValExpr(name) => elem(name)
      case NumberExpr(num) =>
        def stripDot(s: String): String = {
          if (s endsWith ".0") {
            s.substring(0, s.length - 2)
          } else {
            s
          }
        }

        elem(stripDot(num.toString))
      case UnaryOp(op, arg) =>
        elem(op) beside format(arg, unaryPrecedence)
      case BinaryOp("/", left, right) => {
        val top = format(left, fractionPrecedence)
        val bottom = format(right, fractionPrecedence)
        val line = Element.elem('-', top.width max bottom.width, 1)
        val frac = top above line above bottom
        if (enclPrec != fractionPrecedence) {
          frac
        } else {
          elem(" ") beside frac beside elem(" ")
        }
      }
      case BinaryOp(op, left, right) =>
        val opPrec = precedence(op)
        val l = format(left, opPrec)
        val r = format(right, opPrec + 1)
        val oper = l beside elem(" " + op + " ") beside r
        if (enclPrec <= opPrec) {
          oper
        } else {
          elem("(") beside oper beside elem(")")
        }
    }
  }

  def format(e: Expression): Element = format(e, 0)
}

sealed abstract class Expression

case class ValExpr(name: String) extends Expression

case class NumberExpr(num: Double) extends Expression

case class UnaryOp(operator: String, arg: Expression) extends Expression

case class BinaryOp(operator: String, left: Expression, right: Expression) extends Expression