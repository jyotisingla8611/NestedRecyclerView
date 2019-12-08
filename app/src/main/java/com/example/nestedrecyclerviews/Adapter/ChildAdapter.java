package com.example.nestedrecyclerviews.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerviews.R;
import com.example.nestedrecyclerviews.SubItem;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    private List<SubItem> list;

    ChildAdapter() {
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.child_item, parent, false);
        return new ChildViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        holder.setData(list.get(position).getSubItemTitle());
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    void setData(List<SubItem> subItemList) {
        this.list = subItemList;
        notifyDataSetChanged();
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {
        TextView heading;

        ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.child_item_textview);
        }

        void setData(String s) {
            heading.setText(s);
        }
    }
}
