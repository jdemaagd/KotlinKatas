package com.kryptopass.kotlinkatas.data_structures.m9.category

import arrow.core.*

fun main() {
    val optionalVal: Option<Int>
    optionalVal = Some(10)
    println(optionalVal.map { it+1 })                    // 1
    println(optionalVal.map { Some(it+1) })        // 2
}