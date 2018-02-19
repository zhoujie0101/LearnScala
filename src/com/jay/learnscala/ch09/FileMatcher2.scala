package com.jay.learnscala.ch09

import java.io.File

/**
  * Created by jay on 2018/2/16.
  */
object FileMatcher2 {
  private def filesHere(): Array[File] = new File(".").listFiles()


  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere(); if matcher(file.getName, query))
      yield file
  }

  def filesEnding(query: String): Array[File] = {
    filesMatching(query, _.endsWith(_))
  }

  def filesContaining(query: String): Array[File] = {
    filesMatching(query, _.contains(_))
  }
  
  def filesRegex(query: String): Array[File] = {
    filesMatching(query, _.matches(_))
  }
}
