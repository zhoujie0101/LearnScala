package com.jay.learnscala.ch09

import java.io.{File, PrintWriter}
import java.util.Date

/**
  * Created by jay on 2018/2/16.
  * 函数柯里化
  */
object CurryingDemo {
  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def withPrintWriterCurrying(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def main(args: Array[String]): Unit = {
    withPrintWriter(new File("date.txt"), writer => writer.println(new Date))

    withPrintWriterCurrying(new File("date.txt"))(writer => writer.println(new Date))

    withPrintWriterCurrying(new File("date.txt")) {
      writer => writer.println(new Date)
    }
  }
}
