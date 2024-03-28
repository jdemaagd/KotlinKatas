package com.kryptopass.kotlinkatas.data_structures.m9.arrow

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

fun main() {
    var optionalVar: Option<Int>
    optionalVar = Some(10)
    println(optionalVar)
    optionalVar = None
    println(optionalVar)
}