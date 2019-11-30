package com.example.gotakecoffee_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class user_beranda extends AppCompatActivity {

    private RecyclerView recyclerViewCafe;
    private ArrayList<Cafe> listCafe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_beranda);
        recyclerViewCafe = findViewById(R.id.rv_user_beranda);
        recyclerViewCafe.setHasFixedSize(true);

        listCafe.addAll(DataWudlu.getListData());
        tampilCardviewBeranda();
    }

    private void tampilCardviewBeranda() {
        recyclerViewCafe.setLayoutManager(new LinearLayoutManager(this));
        user_adapterCardviewBeranda useradapterCardviewBeranda = new user_adapterCardviewBeranda(listCafe);
        recyclerViewCafe = findViewById(R.id.rv_user_beranda);
        recyclerViewCafe.setAdapter(useradapterCardviewBeranda);
        useradapterCardviewBeranda.setOnItemCallback(new user_adapterCardviewBeranda.OnItemCallback() {
            @Override
            public void onItemClicked(Cafe data) {
                setSelectedCafe(data);
            }
        });
    }

    private void setSelectedCafe(Cafe cafe) {
        Toast.makeText(this, "Membuka " + cafe.getNamaCafe()+"..", Toast.LENGTH_SHORT).show();
        Intent mIntent = new Intent(this, user_detailMenuActivity.class);
        startActivity(mIntent);
    }
}
