package vn.edu.hust.lazadaapp.view.dangnhap;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.adapter.ViewPagerAdapter;
import vn.edu.hust.lazadaapp.view.dangnhap.fragment.LoginFragment;
import vn.edu.hust.lazadaapp.view.dangnhap.dangky.DangKyFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView exitImage;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter mainAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mainAdapter.addFrag(LoginFragment.newInstance(), "Đăng nhập");
        mainAdapter.addFrag(DangKyFragment.newInstance(), "Đăng ký");
        viewPager.setAdapter(mainAdapter);
    }

    private void findView() {
        exitImage = findViewById(R.id.exitImage);
        exitImage.setOnClickListener(this);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(this.viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.exitImage:
            finish();
            break;
        }
    }
}
