package com.fininfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.fininfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var numberList: List<Int>
    lateinit var adapter: NumberAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        numberList = (1..100).toList()
        callAdapter(numberList)
        clickFun()
    }

    private fun clickFun() {
        binding.apply {
            oddTv.setOnClickListener {
                backgroundChange(oddTv, evenTv, primeTv, fibonacciTv)
                val oddNumbers = numberList.filter { it % 2 != 0 }
                callAdapter(oddNumbers)
            }
            evenTv.setOnClickListener {
                backgroundChange(evenTv, oddTv, primeTv, fibonacciTv)
                val evenNumbers = (2..100 step 2).toList()
                callAdapter(evenNumbers)
            }
            primeTv.setOnClickListener {
                backgroundChange(primeTv, oddTv, evenTv, fibonacciTv)
                callAdapter(getPrimes(100))
            }

            fibonacciTv.setOnClickListener {
                backgroundChange(fibonacciTv, oddTv, evenTv, primeTv)
                callAdapter(getFibonacci(100))
            }
        }
    }

    private fun callAdapter(numbers: List<Int>) {
        binding.apply {
            adapter = NumberAdapter(numbers)
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 4)
            recyclerView.adapter = adapter
        }
    }

    private fun backgroundChange(one: TextView, two: TextView, three: TextView, four: TextView) {
        one.background = resources.getDrawable(R.drawable.theme_bg)
        two.background = resources.getDrawable(R.drawable.corner_bg)
        three.background = resources.getDrawable(R.drawable.corner_bg)
        four.background = resources.getDrawable(R.drawable.corner_bg)

        one.setTextColor(resources.getColor(R.color.white))
        two.setTextColor(resources.getColor(R.color.black))
        three.setTextColor(resources.getColor(R.color.black))
        four.setTextColor(resources.getColor(R.color.black))
    }

    fun getFibonacci(limit: Int): List<Int> {
        val list = mutableListOf(0, 1)
        while (true) {
            val next = list[list.size - 1] + list[list.size - 2]
            if (next > limit) break
            list.add(next)
        }
        return list
    }

    fun getPrimes(limit: Int): List<Int> {
        val primes = BooleanArray(limit + 1) { true }
        primes[0] = false
        primes[1] = false

        for (i in 2..limit) {
            if (primes[i]) {
                for (j in i * i..limit step i) {
                    primes[j] = false
                }
            }
        }
        return (2..limit).filter { primes[it] }
    }
}