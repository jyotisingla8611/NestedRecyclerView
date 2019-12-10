package com.example.nestedrecyclerviews.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerviews.R;
import com.example.nestedrecyclerviews.SubItem;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    public List<SubItem> getList() {
        return list;
    }

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

    void clearList() {
        list.clear();
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {
        private TextView heading;
        private ImageButton removeButton;
        private ImageButton shareButton;

        ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.duration);
            removeButton = itemView.findViewById(R.id.remove_button);
            shareButton = itemView.findViewById(R.id.share_button);

            heading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"Child is Clicked!",Toast.LENGTH_LONG).show();
                }
            });

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Remove Button Clicked!",Toast.LENGTH_LONG).show();
                }
            });

            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Share Button Clicked!", Toast.LENGTH_LONG).show();
                }
            });
        }

        void setData(String s) {
//            heading.setText(s);
        }
    }
}
