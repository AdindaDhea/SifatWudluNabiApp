package rizki.aplikasisifatwudlunabi;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class AdapterBerandaActivity extends RecyclerView.Adapter<AdapterBerandaActivity.MyViewHolder> implements Filterable {

    List<SifatWudlu> sifatWudlu, sifatWudluFilter;
    private Context context;
    private RecyclerViewClickListener mListener;
    CustomFilter filter;

    public AdapterBerandaActivity(List<SifatWudlu> sifatWudlu, Context context, RecyclerViewClickListener recyclerViewClickListener) {
        this.sifatWudlu = sifatWudlu;
        this.sifatWudluFilter = sifatWudlu;
        this.context = context;
        this.mListener = recyclerViewClickListener;
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter = new CustomFilter((ArrayList<SifatWudlu>) sifatWudluFilter, this);
        }
        return filter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beranda_item, parent, false);

        return new MyViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.judul.setText(sifatWudlu.get(position).getJudul());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
        requestOptions.placeholder(R.drawable.wudlu);
        requestOptions.error(R.drawable.wudlu);
        Glide.with(context).load(sifatWudlu.get(position).getGambar())
                .apply(requestOptions)
                .apply(requestOptions)
                .into(holder.gambar);
    }

    @Override
    public int getItemCount() {

        return sifatWudlu.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RecyclerViewClickListener mListener;
        private ImageView gambar;
        TextView judul;
        private RelativeLayout mRowContainer;


        public MyViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            gambar = itemView.findViewById(R.id.beranda_item_im_gambar);
            judul = itemView.findViewById(R.id.beranda_item_tv_judul);
            mRowContainer = itemView.findViewById(R.id.beranda_item_id);

            mListener = listener;
            mRowContainer.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.beranda_item_id:
                    mListener.onRowClick(mRowContainer, getAdapterPosition());
                    break;
                default:
                    break;
            }
        }
    }

    public interface RecyclerViewClickListener {
        void onRowClick(View view, int position);
    }
}
