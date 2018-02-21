package com.jay.learnscala.ch20

/**
  * created by zhoujie on 2018/02/20
  */
abstract class AbstractCurrency {
  type Currency <: AbstractCurrency
  val amount: Long
  def designation: String

  def + (that: Currency): Currency = ???

  def * (x: Double): Currency = ???

  override def toString: String = amount + " " + designation
}

