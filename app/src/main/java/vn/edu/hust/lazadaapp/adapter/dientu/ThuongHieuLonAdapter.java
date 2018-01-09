package vn.edu.hust.lazadaapp.adapter.dientu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;

/**
 * Created by HaoLV on 1/2/2018.
 */

public class ThuongHieuLonAdapter extends RecyclerView.Adapter<ThuongHieuLonAdapter.ViewHolder> {
    private ArrayList<ThuongHieu> thuongHieus;
    private Context context;

    public ThuongHieuLonAdapter(Context context, ArrayList<ThuongHieu> thuongHieus) {
        this.context = context;
        this.thuongHieus = thuongHieus;
    }

    //chạy đầu tiên
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_thuong_hieu_lon, parent, false);
        return new ViewHolder(view);
    }

    //chạy thứ 3
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ThuongHieu thuongHieu = thuongHieus.get(position);

        Glide.with(context).load(thuongHieu.getHinhThuongHieu()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return thuongHieus.size();
    }

    //chạy thứ 2
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
