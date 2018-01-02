package vn.edu.hust.lazadaapp.adapter.dientu;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;

/**
 * Created by HaoLV on 1/1/2018.
 */

public class ThuongHieuAdapter extends RecyclerView.Adapter<ThuongHieuAdapter.ViewHolder> {
    private ArrayList<ThuongHieu> thuongHieus;
    private Context context;

    public ThuongHieuAdapter(Context context, ArrayList<ThuongHieu> thuongHieus) {
        this.context = context;
        this.thuongHieus = thuongHieus;
    }

    //chạy đầu tiên
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_thuonghieu, parent, false);
        return new ViewHolder(view);
    }

    //chạy thứ 3
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ThuongHieu thuongHieu = thuongHieus.get(position);
        holder.name.setText(thuongHieu.getTenThuongHieu());
        LogManager.e(ThuongHieuAdapter.this, thuongHieu.getHinhThuongHieu());
        Picasso.with(context).load(thuongHieu.getHinhThuongHieu()).into(holder.imageView, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return thuongHieus.size();
    }

    //chạy thứ 2
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView imageView;
        private ProgressBar progressBar;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.imageView);
            progressBar = itemView.findViewById(R.id.progressBar);

        }
    }
}
