package vn.edu.hust.lazadaapp.adapter.dientu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.model.entity.DienTu;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;

/**
 * Created by HaoLV on 1/2/2018.
 */

public class DienTuAdapter extends RecyclerView.Adapter<DienTuAdapter.ViewHolder> {
    private ArrayList<DienTu> dienTus;
    private Context context;

    public DienTuAdapter(Context context, ArrayList<DienTu> dienTus) {
        this.context = context;
        this.dienTus = dienTus;
    }

    //chạy đầu tiên
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_row_dientu, parent, false);
        return new ViewHolder(view);
    }

    //chạy thứ 3
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DienTu dienTu = dienTus.get(position);

        //adapter thương hiệu lớn
        ThuongHieuAdapter thuongHieuAdapter = new ThuongHieuAdapter(context, dienTu.getThuongHieus());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 3,
                LinearLayoutManager.HORIZONTAL, false);
        holder.thuongHieuRecyclerView.setLayoutManager(layoutManager);
        holder.thuongHieuRecyclerView.setAdapter(thuongHieuAdapter);

        //adapter sản phẩm top
        SanPhamTopAdapter sanPhamAdapter = new SanPhamTopAdapter(context, dienTu.getSanPhams());
        holder.sanPhamRecyclerView.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false));
        holder.sanPhamRecyclerView.setAdapter(sanPhamAdapter);

    }

    @Override
    public int getItemCount() {
        LogManager.e(DienTuAdapter.this, String.valueOf(dienTus.size()));
        return dienTus.size();
    }

    //chạy thứ 2
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private RecyclerView thuongHieuRecyclerView;
        private RecyclerView sanPhamRecyclerView;


        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            thuongHieuRecyclerView = itemView.findViewById(R.id.thuongHieuRecyclerView);
            sanPhamRecyclerView = itemView.findViewById(R.id.sanPhamRecyclerView);
        }
    }

}
