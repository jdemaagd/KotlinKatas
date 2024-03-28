package com.kryptopass.katas.data_structures.m1

import java.util.*
import kotlin.collections.ArrayList

class UpperCasedList : ArrayList<String>() {

    override fun add(
        element: String
    ): Boolean {
        return super.add(element.uppercase(Locale.getDefault()))
    }

    override fun add(
        index: Int, element: String
    ) {
        super.add(index, element.uppercase(Locale.getDefault()))
    }

    override fun addAll(
        elements: Collection<String>
    ): Boolean {
        return super.addAll(elements.map { it.uppercase(Locale.getDefault()) })
    }

    override fun addAll(
        index: Int,
        elements: Collection<String>
    ): Boolean = super.addAll(index, elements.map { it.uppercase(Locale.getDefault()) })

    override fun set(
        index: Int,
        element: String
    ): String {
        return super.set(index, element.uppercase(Locale.getDefault()))
    }
}