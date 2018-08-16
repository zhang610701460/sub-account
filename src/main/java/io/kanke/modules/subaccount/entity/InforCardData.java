package io.kanke.modules.subaccount.entity;

public class InforCardData {
    private String title;
    private String icon;
    private String count;
    private String color;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "InforCardDate{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", count='" + count + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public InforCardData(String title, String icon, String count, String color) {
        this.title = title;
        this.icon = icon;
        this.count = count;
        this.color = color;
    }
}
