package com.valkriaine.factor_example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.valkriaine.factor.BouncyRecyclerView;
import org.jetbrains.annotations.NotNull;

/**
public class MyAdapter extends BouncyRecyclerView.Adapter<MyData>
{
    private final ArrayList<MyData> dataSet;

    public MyAdapter(@NotNull ArrayList<MyData> dataSet)
    {
        super(dataSet);
        this.dataSet = dataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        MyViewHolder h = (MyViewHolder) holder;
        h.getTextView().setText(dataSet.get(position).getData());
    }

    @Override
    public int getItemCount()
    {
        return dataSet.size();
    }

    @Override
    public void onItemMoved(int fromPosition, int toPosition)
    {
        super.onItemMoved(fromPosition, toPosition);
        //called repeatedly when item is dragged (reordered)
    }

    @Override
    public void onItemSwipedToStart(RecyclerView.ViewHolder viewHolder, int position)
    {
        //item swiped left
    }

    @Override
    public void onItemSwipedToEnd(RecyclerView.ViewHolder viewHolder, int position)
    {
        //item swiped right
    }

    @Override
    public void onItemSelected(RecyclerView.ViewHolder viewHolder)
    {
        //item long pressed (selected)
    }

    @Override
    public void onItemReleased(RecyclerView.ViewHolder viewHolder)
    {
        //item released (unselected)
    }
}
*/