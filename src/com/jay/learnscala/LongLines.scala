package com.jay.learnscala

import scala.io.Source

/**
  * Created by jay on 2018/2/15.
  */
object LongLines {

  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(filename, width, line)
    }
  }

  private def processLine(filename: String, width: Int, line: String) = {
    if (line.length > width) {
      println(filename + ": " + line.trim)
    }
  }

  def main(args: Array[String]) = {
    val width = args(0).toInt
    for (arg <- args.drop(1)) {
      processFile(arg, width)
    }
  }
}
