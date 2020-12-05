package com.valkriaine.factor_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.valkriaine.factor.BouncyViewHolder



class DataManager
{
    private val dataList : ArrayList<Data> = ArrayList()

    val adapter = Adapter(dataList)

    fun addData()
    {
        dataList.add(Data("data: " + (dataList.size + 1)))
        adapter.notifyDataSetChanged()
    }

    fun generateData(size : Int)
    {
        for(i in 0..size)
        {
            dataList.add(Data("data : " + (dataList.size + 1)))
        }
        adapter.notifyDataSetChanged()
    }




    class Adapter(private val list: ArrayList<Data>) : RecyclerView.Adapter<Adapter.DataViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder
        {
            val item = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return DataViewHolder(item)
        }

        override fun onBindViewHolder(holder: DataViewHolder, position: Int)
        {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int
        {
            return list.size
        }


        class DataViewHolder(itemView: View) : BouncyViewHolder(itemView)
        {
            private val dataText : TextView = itemView.findViewById(R.id.data)

            fun bind(item: Data) = with(itemView)
            {
                dataText.text = item.data
                itemView.setOnClickListener()
                {
                    Toast.makeText(context, item.data + " clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}