package io.kanke.modules.subaccount.entity;

import java.util.Map;

public class HomePage {

    private InforCardData inforCardData;
    private PieData pieData;
    private Map barData;


    public InforCardData getInforCardData() {
        return inforCardData;
    }

    public void setInforCardData(InforCardData inforCardData) {
        this.inforCardData = inforCardData;
    }

    public PieData getPieData() {
        return pieData;
    }

    public void setPieData(PieData pieData) {
        this.pieData = pieData;
    }

    public Map getBarData() {
        return barData;
    }

    public void setBarData(Map barData) {
        this.barData = barData;
    }

    public HomePage(InforCardData inforCardData, PieData pieData, Map barData) {
        this.inforCardData = inforCardData;
        this.pieData = pieData;
        this.barData = barData;
    }
}
