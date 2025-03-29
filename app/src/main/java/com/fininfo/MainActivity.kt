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
        callAdapter("all")
        clickFun()
    }

    private fun clickFun() {
        binding.apply {
            oddTv.setOnClickListener {
                backgroundChange(oddTv, evenTv, primeTv, fibonacciTv)
                val oddNumbers = numberList.filter { it % 2 != 0 }
                callAdapter("odd")
            }
            evenTv.setOnClickListener {
                backgroundChange(evenTv, oddTv, primeTv, fibonacciTv)
                val evenNumbers = (2..100 step 2).toList()
                callAdapter("even")
            }
            primeTv.setOnClickListener {
                backgroundChange(primeTv, oddTv, evenTv, fibonacciTv)
                callAdapter("prime")
            }

            fibonacciTv.setOnClickListener {
                backgroundChange(fibonacciTv, oddTv, evenTv, primeTv)
                callAdapter("fibonacci")
            }
        }
    }

    private fun callAdapter(type:String) {
        binding.apply {
            val numbers = (1..100).map { NumberItem(it, NumberUtils.getNumberType(it)) }
            adapter = NumberAdapter(numbers,type)
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


}