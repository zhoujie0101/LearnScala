package com.jay.learnscala.ch09

import java.io.File

/**
  * Created by jay on 2018/2/16.
  */
object FileMatcher3 {
  private def filesHere(): Array[File] = new File(".").listFiles()

  def filesMatching(matcher: String => Boolean) = {
    for (file <- filesHere(); if matcher(file.getName))
      yield file
  }

  def filesEnding(query: String): Array[File] = {
    filesMatching(_.endsWith(query))
  }

  def filesContaining(query: String): Array[File] = {
    filesMatching(_.contains(query))
  }
  
  def filesRegex(query: String): Array[File] = {
    filesMatching(_.matches(query))
  }
}
