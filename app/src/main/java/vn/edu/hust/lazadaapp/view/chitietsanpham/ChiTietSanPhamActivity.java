package vn.edu.hust.lazadaapp.view.chitietsanpham;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.adapter.ImageSliderAdapter;
import vn.edu.hust.lazadaapp.adapter.dientu.SanPhamTopAdapter;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.presenter.chitietsanpham.ChiTietPresenter;

public class ChiTietSanPhamActivity extends AppCompatActivity implements ChiTietSanPhamView, ViewPager.OnPageChangeListener {
    private int maSanPham;
    private ChiTietPresenter chiTietPresenter;
    private ArrayList<Fragment> fragments;
    private LinearLayout layoutDots;
    private TextView[] txtDots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        maSanPham = getIntent().getIntExtra(SanPhamTopAdapter.MA_SP, -1);
        LogManager.e(ChiTietSanPhamActivity.this, String.valueOf(maSanPham));

        //findView
        layoutDots = findViewById(R.id.layoutDots);
        chiTietPresenter = new ChiTietPresenter(this);
        chiTietPresenter.getChiTietSanPham(String.valueOf(maSanPham));
    }


    @Override
    public void hienThiChiTiet(SanPham sanPham) {
        LogManager.e(ChiTietSanPhamActivity.this, sanPham.toString());
    }

    @Override
    public void hienThiImageSlider(String[] imageUrl) {
        fragments = new ArrayList<>();
        for (String anImageUrl : imageUrl) {
            ImageViewFragment imageViewFragment = ImageViewFragment.newInstance(anImageUrl);
            fragments.add(imageViewFragment);
        }
        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageSliderAdapter adapterViewPagerSlider = new ImageSliderAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapterViewPagerSlider);

        updateDotSlider(0);
        viewPager.addOnPageChangeListener(this);
    }

    private void updateDotSlider(int vitrihientai) {
        txtDots = new TextView[fragments.size()];

        layoutDots.removeAllViews();
        for (int i = 0; i < fragments.size(); i++) {
            txtDots[i] = new TextView(this);
            txtDots[i].setText(Html.fromHtml("&#8226;"));
            txtDots[i].setTextSize(40);
            txtDots[i].setTextColor(getIdColor(R.color.colorSliderInActive));

            layoutDots.addView(txtDots[i]);
        }

        txtDots[vitrihientai].setTextColor(getIdColor(R.color.bgToolbar));
    }

    private int getIdColor(int idcolor) {

        int color = 0;
        if (Build.VERSION.SDK_INT > 21) {
            color = ContextCompat.getColor(this, idcolor);
        } else {
            color = getResources().getColor(idcolor);
        }

        return color;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        updateDotSlider(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
