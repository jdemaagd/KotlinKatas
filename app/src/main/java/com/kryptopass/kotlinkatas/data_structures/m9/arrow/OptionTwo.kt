package com.kryptopass.kotlinkatas.data_structures.m9.arrow

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.getOrElse

fun main() {
    printOptionalInt(Some(10))
    printOptionalInt(Some(2))
    printOptionalInt(None)
    printOptionalInt(Some(200))
    printOptionalInt(None)
}

fun printOptionalInt(optionalInt: Option<Int>) {
    if(optionalInt is None) {
        println("It's blank")
    } else {
        println("It's ${optionalInt.getOrElse { 0 }}")
    }
}