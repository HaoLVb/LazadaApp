package vn.edu.hust.lazadaapp.adapter.dientu;

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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;

/**
 * Created by HaoLV on 1/2/2018.
 */

public class SanPhamTopAdapter extends RecyclerView.Adapter<SanPhamTopAdapter.ViewHolder> {
    private ArrayList<SanPham> sanPhams;
    private Context context;

    public SanPhamTopAdapter(Context context, ArrayList<SanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
    }

    //chạy đầu tiên
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_sanpham_top, parent, false);
        return new ViewHolder(view);
    }

    //chạy thứ 3
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final SanPham sanPham = sanPhams.get(position);
        LogManager.e(SanPhamTopAdapter.this, sanPham.toString());
        holder.name.setText(sanPham.getTenSanPham());
        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(sanPham.getGia());
        holder.giaText.setText(gia + " VNĐ ");
        Picasso.with(context).load(sanPham.getAnhLon()).into(holder.imageView, new Callback() {
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
        return sanPhams.size();
    }

    //chạy thứ 2
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name;
        private TextView giaText;
        private TextView giamGiaText;
        private ProgressBar progressBar;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            giaText = itemView.findViewById(R.id.giaText);
            giamGiaText = itemView.findViewById(R.id.giamGiaText);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
