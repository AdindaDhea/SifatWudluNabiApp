package com.example.gotakecoffee_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int waktuLoading = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent userBeranda = new Intent(MainActivity.this, user_beranda.class);
                startActivity(userBeranda);
                finish();
            }
        }, waktuLoading);
    }

    @Override
    public void onClick(View v) {

    }
}
