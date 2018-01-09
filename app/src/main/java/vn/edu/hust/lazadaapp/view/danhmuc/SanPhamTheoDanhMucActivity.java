package vn.edu.hust.lazadaapp.view.danhmuc;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.login.LoginManager;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.adapter.dientu.SanPhamTopAdapter;
import vn.edu.hust.lazadaapp.model.dangnhap.DangNhapModel;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.presenter.danhmuc.DanhMucPresenter;
import vn.edu.hust.lazadaapp.view.dangnhap.LoginActivity;
import vn.edu.hust.lazadaapp.view.trangchu.fragment.DienTuFragment;

public class SanPhamTheoDanhMucActivity extends AppCompatActivity implements SanPhamDanhMucView {

    private Toolbar toolbar;
    private String name;
    private int maSanPham;
    private DanhMucPresenter danhMucPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_theo_danh_muc);
        findView();
        initData();
    }

    private void findView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//không hiện tên app trên toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initData() {
        name = getIntent().getStringExtra(DienTuFragment.TEN_THUONGHIEU);
        maSanPham = getIntent().getIntExtra(DienTuFragment.MA_THUONGHIEU, -1);
        toolbar.setTitle(name);
        toolbar.setTitleTextColor(Color.WHITE);
        danhMucPresenter = new DanhMucPresenter(this);
        danhMucPresenter.laySanPhamTheoDanhMuc(maSanPham, 10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void hienThiSanPhamTheoDanhMuc(ArrayList<SanPham> sanPhams) {
        SanPhamTopAdapter adapter = new SanPhamTopAdapter(this, sanPhams);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
