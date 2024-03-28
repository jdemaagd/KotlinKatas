package com.kryptopass.katas.data_structures.m9.basics

fun highOrder(anotherFunc: () -> Unit) {
    println("Before anotherFunc()")
    anotherFunc()
    println("After anotherFunc()")
}

fun main() {
    highOrder {
        println("anotherFunc()")
    }
}