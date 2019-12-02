package rizki.aplikasisifatwudlunabi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class DetailKontenActivity extends AppCompatActivity {

    ImageView imgambar;
    TextView tvjudul, tvisi_konten, tvsumber_isi, tvsumber_gambar;

    private String  gambar, judul, isi_konten, sumber_isi, sumber_gambar;
    private int id;
    private Bitmap bitmap;

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_konten_activity);
        tvjudul = findViewById(R.id.detail_konten_tv_judul);
        tvisi_konten = findViewById(R.id.detail_konten_tv_detail_penjelasan);
        tvsumber_isi = findViewById(R.id.detail_konten_tv_sumber_isi);
        tvsumber_gambar = findViewById(R.id.detail_konten_sumber_gambar);
        imgambar = findViewById(R.id.detail_konten_im_header);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        judul = intent.getStringExtra("judul");
        gambar = intent.getStringExtra("gambar");
        System.out.println("haiahi"+judul);
        isi_konten = intent.getStringExtra("isi_konten");
        sumber_isi = intent.getStringExtra("sumber_isi");
        sumber_gambar = intent.getStringExtra("sumber_gambar");
        setDataFromIntentExtra();
    }
    private void setDataFromIntentExtra(){
        if (id!=0){
            getSupportActionBar().setTitle("Baca: " + judul.toString());

            tvjudul.setText(judul);
            tvisi_konten.setText(isi_konten);
            tvsumber_isi.setText(sumber_isi);

            RequestOptions requestOptions = new RequestOptions();
            requestOptions.skipMemoryCache(true);
            requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
            requestOptions.placeholder(R.drawable.wudlu);
            requestOptions.error(R.drawable.wudlu);

            Glide.with(DetailKontenActivity.this)
                    .load(gambar)
                    .apply(requestOptions)
                    .into(imgambar);
        }
    }
}

