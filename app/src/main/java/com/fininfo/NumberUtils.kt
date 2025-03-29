package com.fininfo

object NumberUtils {

    fun isPrime(n: Int): Boolean {

        if (n < 2) return false
        for (i in 2 until n) {
            if (n % i == 0) return false
        }
        return true
    }

    fun isFibonacci(n: Int): Boolean {
        var a = 0
        var b = 1
        while (b < n) {
            val temp = b
            b += a
            a = temp
        }
        return b == n || n == 0
    }

    fun getNumberType(n: Int): NumberType {
        return when {
            isPrime(n) -> NumberType.PRIME
            isFibonacci(n) -> NumberType.FIBONACCI
            n % 2 == 0 -> NumberType.EVEN
            else -> NumberType.ODD
        }
    }
}