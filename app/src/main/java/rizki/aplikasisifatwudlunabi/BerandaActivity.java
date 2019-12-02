package rizki.aplikasisifatwudlunabi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BerandaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterBerandaActivity adapter;
    private List<SifatWudlu> kontenList;
    ApiInterface apiInterface;
    AdapterBerandaActivity.RecyclerViewClickListener listener;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beranda_activity);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        recyclerView = findViewById(R.id.rv_user_beranda);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        listener = new AdapterBerandaActivity.RecyclerViewClickListener() {
            @Override
            public void onRowClick(View view, int position) {
                Intent intent = new Intent(BerandaActivity.this, DetailKontenActivity.class);
                intent.putExtra("id", kontenList.get(position).getId());
                intent.putExtra("judul", kontenList.get(position).getJudul());
                intent.putExtra("gambar", kontenList.get(position).getGambar());
                intent.putExtra("isi_konten", kontenList.get(position).getIsi_konten());
                intent.putExtra("sumber_isi", kontenList.get(position).getSumber_isi());
                intent.putExtra("sumber_gambar", kontenList.get(position).getSumber_gambar());
                intent.putExtra("dibuat_pada", kontenList.get(position).getDibuat_pada());
                startActivity(intent);

            }
        };

    }


    public void getPets() {

        Call<List<SifatWudlu>> call = apiInterface.readKonten();
        call.enqueue(new Callback<List<SifatWudlu>>() {
            @Override
            public void onResponse(Call<List<SifatWudlu>> call, Response<List<SifatWudlu>> response) {
//                progressBar.setVisibility(View.GONE);
                kontenList = response.body();
                Log.i(BerandaActivity.class.getSimpleName(), response.body().toString());
                adapter = new AdapterBerandaActivity(kontenList, BerandaActivity.this, listener);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SifatWudlu>> call, Throwable t) {
                Toast.makeText(BerandaActivity.this, "rp :" +
                                t.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPets();
    }
}
