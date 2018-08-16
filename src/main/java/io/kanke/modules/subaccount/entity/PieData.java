package io.kanke.modules.subaccount.entity;

public class PieData {

    private  String value;
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieData(String value, String name) {
        this.value = value;
        this.name = name;
    }
}
