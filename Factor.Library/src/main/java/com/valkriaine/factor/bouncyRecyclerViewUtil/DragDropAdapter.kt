package com.valkriaine.factor.bouncyRecyclerViewUtil

import androidx.recyclerview.widget.RecyclerView

interface DragDropAdapter
{
    fun onItemMoved(fromPosition: Int, toPosition: Int)
    fun onItemSwipedFromStart(viewHolder: RecyclerView.ViewHolder?, position: Int)
    fun onItemSwipedFromEnd(viewHolder: RecyclerView.ViewHolder?, position: Int)
    fun onItemSelected(viewHolder: RecyclerView.ViewHolder?)
    fun onItemReleased(viewHolder: RecyclerView.ViewHolder?)
}