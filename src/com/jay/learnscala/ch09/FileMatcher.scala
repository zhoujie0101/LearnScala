package com.jay.learnscala.ch09

import java.io.File

/**
  * Created by jay on 2018/2/16.
  */
object FileMatcher {
  private def filesHere(): Array[File] = new File(".").listFiles()

  def filesEnding(query: String): Array[File] =
    for (file <- filesHere(); if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String): Array[File] =
    for (file <- filesHere(); if file.getName.contains(query))
      yield file

  def filesRegex(query: String): Array[File] =
    for (file <- filesHere(); if file.getName.matches(query))
      yield file
}
