package com.fininfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fininfo.databinding.NumberAdapterBinding

class NumberAdapter(var numberList: List<Int>) :
    RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        var view = NumberAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.apply {

            onBind(numberList, position)
        }
    }

    override fun getItemCount(): Int {
        return numberList.size
    }

    class NumberViewHolder(var view: NumberAdapterBinding) : RecyclerView.ViewHolder(view.root) {
        fun onBind(numberList: List<Int>, position: Int) {
            view.apply {
                number.text = numberList[position].toString()

            }
        }
    }
}