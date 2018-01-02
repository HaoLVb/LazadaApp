package vn.edu.hust.lazadaapp.adapter;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.model.entity.LoaiSanPham;
import vn.edu.hust.lazadaapp.model.trangchu.menu.MenuModel;

/**
 * Created by HaoLV on 12/28/2017.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<LoaiSanPham> loaiSanPhams;
    ViewHolderMenu viewHolderMenu;

    public ExpandableAdapter(Context context, ArrayList<LoaiSanPham> loaiSanPhams) {
        this.context = context;
        this.loaiSanPhams = loaiSanPhams;
        MenuModel menuModel = MenuModel.getInstance();
        for (int i = 0; i < loaiSanPhams.size(); i++) {
            int maloaisp = loaiSanPhams.get(i).getMaLoaiSp();
            loaiSanPhams.get(i).setSanPhams(menuModel.layDanhSachMenuTheoMa(maloaisp));
        }
    }

    @Override
    public int getGroupCount() {
        return loaiSanPhams.size();
    }

    @Override
    public int getChildrenCount(int vitriGroupCha) {
        if (loaiSanPhams.get(vitriGroupCha).getSanPhams().size() != 0) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public Object getGroup(int vitriGroupCha) {
        return loaiSanPhams.get(vitriGroupCha);
    }

    @Override
    public Object getChild(int vitriGroupCha, int vitriGroupCon) {
        return loaiSanPhams.get(vitriGroupCha).getSanPhams().get(vitriGroupCon);
    }

    @Override
    public long getGroupId(int vitriGroupCha) {
        return loaiSanPhams.get(vitriGroupCha).getMaLoaiSp();
    }

    @Override
    public long getChildId(int vitriGroupCha, int vitriGroupCon) {
        return loaiSanPhams.get(vitriGroupCha).getSanPhams().get(vitriGroupCon).getMaLoaiSp();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public class ViewHolderMenu {
        TextView txtTenLoaiSP;
        ImageView hinhMenu;
    }

    @Override
    public View getGroupView(final int vitriGroupCha, boolean isExpanded, View view, ViewGroup viewGroup) {

        View viewGroupCha = view;
        if (viewGroupCha == null) {
            viewHolderMenu = new ViewHolderMenu();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewGroupCha = layoutInflater.inflate(R.layout.custom_group_menu, viewGroup, false);

            viewHolderMenu.txtTenLoaiSP = (TextView) viewGroupCha.findViewById(R.id.txtTenLoaiSP);
            viewHolderMenu.hinhMenu = (ImageView) viewGroupCha.findViewById(R.id.imMenuPlus);

            viewGroupCha.setTag(viewHolderMenu);
        } else {
            viewHolderMenu = (ViewHolderMenu) viewGroupCha.getTag();
        }

        viewHolderMenu.txtTenLoaiSP.setText(loaiSanPhams.get(vitriGroupCha).getTenLoaiSp());

        int demsanphamcon = loaiSanPhams.get(vitriGroupCha).getSanPhams().size();

        if (demsanphamcon > 0) {
            viewHolderMenu.hinhMenu.setVisibility(View.VISIBLE);
        } else {
            viewHolderMenu.hinhMenu.setVisibility(View.INVISIBLE);
        }

        if (isExpanded) {
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_remove_black_24dp);
            viewGroupCha.setBackgroundResource(R.color.colorGray);
        } else {
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_add_black_24dp);
            viewGroupCha.setBackgroundResource(R.color.white);
        }
        viewGroupCha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                LogManager.e(context, loaiSanPhams.get(vitriGroupCha).getTenLoaiSp() + " - " + loaiSanPhams.get(vitriGroupCha).getMaLoaiSp());
                return false;
            }
        });


        return viewGroupCha;
    }


    @Override
    public View getChildView(int vitriGroupCha, int vitriGroupCon, boolean isExpanded, View view, ViewGroup viewGroup) {

        SecondExpanable secondExpanable = new SecondExpanable(context);
        ExpandableAdapter secondAdapter = new ExpandableAdapter(context, loaiSanPhams.get(vitriGroupCha).getSanPhams());
        secondExpanable.setAdapter(secondAdapter);

        secondExpanable.setGroupIndicator(null);
        notifyDataSetChanged();

        return secondExpanable;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


    public class SecondExpanable extends ExpandableListView {

        public SecondExpanable(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            int width = size.x;
            int height = size.y;
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }


}
