package com.example.nestedrecyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nestedrecyclerviews.Adapter.ParentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.parent_recyclerview);
        ParentAdapter adapter = new ParentAdapter(buildItemList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private List<Item> buildItemList() {
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Item item;
            if (i == 5 || i == 8)
                item = new Item("Item " + i, buildSubItemList20(), false);
            else
                item = new Item("Item " + i, buildSubItemList(), false);
            itemList.add(item);
        }
        return itemList;
    }

    private List<SubItem> buildSubItemList() {
        List<SubItem> subItemList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            SubItem subItem = new SubItem("Sub Item " + i, "Description " + i);
            subItemList.add(subItem);
        }
        return subItemList;
    }

    private List<SubItem> buildSubItemList20() {
        List<SubItem> subItemList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            SubItem subItem = new SubItem("Sub Item " + i, "Description " + i);
            subItemList.add(subItem);
        }
        return subItemList;
    }
}
