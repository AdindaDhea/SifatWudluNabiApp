package rizki.aplikasisifatwudlunabi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button lanjutBeranda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        lanjutBeranda= findViewById(R.id.home_btn_lanjut);
        lanjutBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBeranda = new Intent(HomeActivity.this, BerandaActivity.class);
                startActivity(intentBeranda);
            }
        });
    }
}
