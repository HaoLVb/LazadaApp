package vn.edu.hust.lazadaapp.adapter.dientu;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL;

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
        Glide.with(context).load(thuongHieu.getHinhThuongHieu()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                holder.progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(holder.imageView);

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
