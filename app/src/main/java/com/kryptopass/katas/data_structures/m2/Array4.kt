package com.kryptopass.katas.data_structures.m2

// NOTE: Array List
fun main(args: Array<String>) {
    val companies = arrayListOf("Google", "Microsoft", "Facebook", "Apple", "JetBrains")
    println("Companies list - $companies")

    companies.add("Amazon")
    companies.add("Samsung")
    println("Companies list - $companies")

    companies.set(2, "Twitter")
    println("Companies list - $companies")

    companies.remove("Samsung")
    companies.removeAt(2)
    println("Companies list - $companies")
}