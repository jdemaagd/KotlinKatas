package ds.m9.category

import arrow.core.*

fun main() {
    var optionalVal: Option<Int>
    optionalVal = Some(10)
    println(optionalVal.map { "It is $it" })
    optionalVal = None
    println(optionalVal.map { "It is $it" })
}