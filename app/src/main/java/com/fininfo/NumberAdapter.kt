package com.fininfo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.fininfo.databinding.NumberAdapterBinding

class NumberAdapter(private val numberList: List<NumberItem>,var type:String) :
    RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        var view = NumberAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val item = numberList[position]
        holder.number.text = item.value.toString()


        if(type.equals("odd",ignoreCase = true)){
            if (item.value % 2 != 0) {
                holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.odd_color))
            }else{
                holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
            }
        }else if(type.equals("even",ignoreCase = true)){
            if(item.value % 2 == 0){
                holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.even_color))
            }else{
                holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
            }
        }else if(type.equals("prime",ignoreCase = true)){
            if(NumberUtils.isPrime(item.value)){
                holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.prime_color))
            }else{
                holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
            }
        } else if(type.equals("fibonacci",ignoreCase = true)){
            if(NumberUtils.isFibonacci(item.value)){
                holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.fibno_color))
            }else{
                holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
            }
        }else {
            holder.number.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
        }

    }

    override fun getItemCount(): Int {
        return numberList.size
    }


    class NumberViewHolder(var view: NumberAdapterBinding) : RecyclerView.ViewHolder(view.root) {
        var number = view.number
        }

}