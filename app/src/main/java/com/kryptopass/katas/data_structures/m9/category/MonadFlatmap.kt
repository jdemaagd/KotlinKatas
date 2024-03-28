package com.kryptopass.katas.data_structures.m9.category

import arrow.core.Option
import arrow.core.Some

fun main() {
    val someValue: Option<Int> = Some(10)
    println(someValue.flatMap { Some(it + 5) })
}