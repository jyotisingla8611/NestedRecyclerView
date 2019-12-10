package com.example.nestedrecyclerviews.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerviews.Item;
import com.example.nestedrecyclerviews.R;
import com.example.nestedrecyclerviews.SubItem;

import java.util.ArrayList;
import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> implements ChildAdapterListener {

    private final List<Item> list;
    private int previousPosition = -1;

    public ParentAdapter(List<Item> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.child_main, parent, false);
        return new ParentViewHolder(listItem, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public void onViewRecycled(@NonNull ParentViewHolder holder) {
        super.onViewRecycled(holder);
        holder.subItemAdapter.setData(new ArrayList<SubItem>());
        holder.recyclerView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onChildStateChanged(int prevAdapterPos) {
        if (prevAdapterPos < 0 || prevAdapterPos >= list.size()) return;
        list.get(prevAdapterPos).setFlag(false);
        notifyItemChanged(prevAdapterPos);
    }

    class ParentViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout mainLayout;
        private TextView heading;
        private RecyclerView recyclerView;
        private Item item;
        private ChildAdapter subItemAdapter = new ChildAdapter();
        private ChildAdapterListener listener;

        ParentViewHolder(@NonNull View itemView, final ChildAdapterListener listener) {
            super(itemView);
            mainLayout = itemView.findViewById(R.id.main_layout);
            heading = itemView.findViewById(R.id.episodeName);
            recyclerView = itemView.findViewById(R.id.child_recyclerview);
            this.listener = listener;
            recyclerView.setAdapter(subItemAdapter);
            recyclerView.setVisibility(View.GONE);

            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Child is Clicked!", Toast.LENGTH_LONG).show();
                    Log.d("Just_Check", "" + getAdapterPosition() + " ");
                    item.setFlag(!item.getFlag());
                    setRecyclerView(item.getFlag());
                    listener.onChildStateChanged(getAdapterPosition() == previousPosition ? -1 : previousPosition);
                    previousPosition = getAdapterPosition();
                }
            });
        }

        void setRecyclerView(Boolean shouldShowView) {
//            if(subItemAdapter.getList() == null || subItemAdapter.getList().size() == 0){
//                subItemAdapter.setData(item.getSubItemList());
//            }else{
////                subItemAdapter.clearList();
////                subItemAdapter.setData(new ArrayList<SubItem>());
//            }
//            subItemAdapter.notifyDataSetChanged();
            recyclerView.setVisibility(shouldShowView ? View.VISIBLE : View.GONE);
        }

        void setData(Item item) {
            this.item = item;
//            heading.setText(item.getItemTitle());
           subItemAdapter.setData(item.getSubItemList());
        }
    }
}

interface ChildAdapterListener {
    void onChildStateChanged(int prevAdapterPos);
}
