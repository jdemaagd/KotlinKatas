package com.kryptopass.kotlinkatas.data_structures.m8

val Int.isPrime: Boolean
    get() {
        for (i in 2..this/2) {
            if(this%i == 0) return false
        }
        return true
    }

fun main() {
    (1..100).filter { it.isPrime }
}