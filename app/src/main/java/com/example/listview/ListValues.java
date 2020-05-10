package com.example.listview;


public class ListValues
{
    private String LeftItem;
    private String RightItem;
    public ListValues(String value1, String value2)
    {
        LeftItem = value1;
        RightItem = value2;
    }

    public String getLeftItem() {
        return LeftItem;
    }

    public void setLeftItem(String leftItem) {
        LeftItem = leftItem;
    }

    public String getRightItem() {
        return RightItem;
    }

    public void setRightItem(String rightItem) {
        RightItem = rightItem;
    }
}
