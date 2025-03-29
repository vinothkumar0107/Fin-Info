package com.fininfo

data class NumberItem(val value: Int, val type: NumberType)

enum class NumberType {
    ODD, EVEN, PRIME, FIBONACCI
}