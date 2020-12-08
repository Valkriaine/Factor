package com.valkriaine.factor_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.valkriaine.factor.BouncyRecyclerView
import kotlin.collections.ArrayList


class DataManager
{
    private val dataList : ArrayList<Data> = ArrayList()

    val adapter = Adapter(dataList)

    fun generateData(size: Int)
    {
        for(i in 0..size)
        {
            dataList.add(Data("data : " + (dataList.size + 1)))
        }
        adapter.notifyDataSetChanged()
    }

    class Adapter(private val list: ArrayList<Data>) : BouncyRecyclerView.Adapter()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
        {
            val item = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return DataViewHolder(item)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
        {
            (holder as DataViewHolder).bind(list[position])
        }

        override fun onItemMoved(fromPosition: Int, toPosition: Int)
        {
            val item = list.removeAt(fromPosition)
            list.add(toPosition, item)
            notifyItemMoved(fromPosition, toPosition)
        }

        override fun onItemSwipedToStart(viewHolder: RecyclerView.ViewHolder?, positionOfItem: Int)
        {
            list[positionOfItem].data += " swiped left"
            notifyItemChanged(positionOfItem)
        }

        override fun onItemSwipedToEnd(viewHolder: RecyclerView.ViewHolder?, positionOfItem: Int)
        {
            list[positionOfItem].data += " swiped right"
            notifyItemChanged(positionOfItem)
        }

        override fun onItemSelected(viewHolder: RecyclerView.ViewHolder?)
        {
            (viewHolder as DataViewHolder).background.alpha = 0.5F
        }

        override fun onItemReleased(viewHolder: RecyclerView.ViewHolder?)
        {
            (viewHolder as DataViewHolder).background.alpha = 1F
        }

        override fun getItemCount(): Int
        {
            return list.size
        }

        class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
        {
            private val dataText : TextView = itemView.findViewById(R.id.data)
            val background: ConstraintLayout = itemView.findViewById(R.id.background)

            fun bind(item: Data) = with(itemView)
            {
                dataText.text = item.data
                itemView.setOnClickListener()
                {
                    dataText.text = item.data + " clicked"
                }
            }
        }

    }
}