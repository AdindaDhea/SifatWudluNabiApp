package com.example.gotakecoffee_2;

import java.util.ArrayList;

public class DataWudlu {
    public static ArrayList<Cafe> getListData(){
        ArrayList<Cafe> listcafe = new ArrayList<>();
        listcafe.add(new Cafe("Sifat Wudlu Nabi", "Lokasi A", 4, 4, 14, "09.00", "23.59",R.drawable.wudlu));
        listcafe.add(new Cafe("Sunnah Wudlu", "Lokasi B", 3, 5, 12, "10.00", "23.59",R.drawable.wudlu));
        listcafe.add(new Cafe("Pembatal Wudlu", "Lokasi C", 5, 14, 17, "07.00", "23.59",R.drawable.wudlu));
        listcafe.add(new Cafe("Hal yang Terlarang", "Lokasi D", 3, 6, 18, "13.00", "23.59",R.drawable.wudlu));
        return listcafe;
    }

}
