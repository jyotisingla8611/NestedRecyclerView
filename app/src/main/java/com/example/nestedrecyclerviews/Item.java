package com.example.nestedrecyclerviews;

import java.util.List;

public class Item {
    private String itemTitle;
    private List<SubItem> subItemList;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    private Boolean flag;

    Item(String itemTitle, List<SubItem> subItemList, Boolean flag) {
        this.itemTitle = itemTitle;
        this.subItemList = subItemList;
        this.flag = flag;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public List<SubItem> getSubItemList() {
        return subItemList;
    }

    public void setSubItemList(List<SubItem> subItemList) {
        this.subItemList = subItemList;
    }
}
