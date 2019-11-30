package com.example.gotakecoffee_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class user_adapterCardviewBeranda extends RecyclerView.Adapter<user_adapterCardviewBeranda.CardViewHolder> {


    private ArrayList<Cafe> listCafe;
    private OnItemCallback onItemCallback;

    public interface OnItemCallback {
        void onItemClicked(Cafe data);
    }

    public void setOnItemCallback(OnItemCallback onItemCallback) {
        this.onItemCallback = onItemCallback;
    }

    public user_adapterCardviewBeranda(ArrayList<Cafe> listCafe) {
        this.listCafe = listCafe;
    }

    @NonNull
    @Override
    public user_adapterCardviewBeranda.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_menu, parent, false);

        return new CardViewHolder(view);
    }

    //Membuat hanya view yang tampil dan akan ditampilkan ke layar saja yang akan diproses dan untuk yang tidak sedang berada di dalam layar, datanya akan tidak digunakan dan akan hanya diikatkan pada data yang ditampilkan saja
    @Override
    public void onBindViewHolder(@NonNull final user_adapterCardviewBeranda.CardViewHolder holder, int position) {
        Cafe cafe = listCafe.get(position);
        holder.imFotoCafe.setImageResource(cafe.getFotoCafe());
        holder.tvNamaCafe.setText(cafe.getNamaCafe());
//        holder.tvRating.setText(String.valueOf(cafe.getRating()));
//        holder.tvSeatTersedia.setText(String.valueOf(cafe.getSeatTersedia()));
//        holder.tvSeatMax.setText(String.valueOf(cafe.getSeatMax()));
//        holder.jamBuka.setText(String.valueOf(cafe.getJamBuka()));
//        holder.jamTutup.setText(cafe.getJamTutup());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemCallback.onItemClicked(listCafe.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCafe.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imFotoCafe;
        TextView tvNamaCafe;
//                , tvRating, tvSeatTersedia, tvSeatMax, lokasiCafe, jamBuka, jamTutup;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imFotoCafe = itemView.findViewById(R.id.im_menu);
            tvNamaCafe = itemView.findViewById(R.id.tv_nama_cafe);
//            tvRating = itemView.findViewById(R.id.tv_rating_cafe);
//            lokasiCafe = itemView.findViewById(R.id.tv_lokasi_cafe);
//            jamBuka = itemView.findViewById(R.id.tv_buka_pada);
//            jamTutup = itemView.findViewById(R.id.tv_tutup_pada);
//            tvSeatTersedia = itemView.findViewById(R.id.tv_sisa_seat);
//            tvSeatMax = itemView.findViewById(R.id.tv_max_seat);

        }
    }
}
