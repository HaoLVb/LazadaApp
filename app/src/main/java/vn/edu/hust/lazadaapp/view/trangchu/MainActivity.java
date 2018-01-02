package vn.edu.hust.lazadaapp.view.trangchu;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
;import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.adapter.ExpandableAdapter;
import vn.edu.hust.lazadaapp.adapter.ViewPagerAdapter;
import vn.edu.hust.lazadaapp.model.dangnhap.DangNhapModel;
import vn.edu.hust.lazadaapp.model.entity.LoaiSanPham;
import vn.edu.hust.lazadaapp.presenter.trangchu.menu.MenuPresenter;
import vn.edu.hust.lazadaapp.view.dangnhap.LoginActivity;
import vn.edu.hust.lazadaapp.view.trangchu.fragment.BlankFragment;
import vn.edu.hust.lazadaapp.view.trangchu.fragment.DienTuFragment;

public class MainActivity extends AppCompatActivity implements MenuView {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ExpandableListView navigationListView;
    private ActionBarDrawerToggle drawerToggle;
    private String userName;
    private MenuPresenter presenter;

    private Menu menu;
    private MenuItem loginItem;
    private MenuItem logoutItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_main);
        findView();
        getMenu();
    }

    private void getMenu() {
        presenter = new MenuPresenter(this);
        presenter.layDanhSachMenu();
        presenter.layTokenFacebook();
    }

    private void findView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//không hiện tên app trên toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tabLayout);
        this.viewPager = findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        this.tabLayout.setupWithViewPager(this.viewPager);
        setDrawer();
        navigationListView = findViewById(R.id.navigationListView);
    }

    private void setDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        this.menu = menu;
        loginItem = menu.findItem(R.id.loginItem);
        logoutItem = menu.findItem(R.id.logoutItem);
        String tennv = DangNhapModel.getInstance().getCacheLogin(this);
        if (!tennv.equals("")) {
            setProfileUser(tennv);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.loginItem:
                Intent loginIntent = new Intent(this, LoginActivity.class);
                startActivity(loginIntent);
                break;
            case R.id.logoutItem:
                LoginManager.getInstance().logOut();
                if (!DangNhapModel.getInstance().getCacheLogin(this).equals("")) {
                    DangNhapModel.getInstance().updateCacheLogin(this, "");
                }
                this.menu.clear();
                this.onCreateOptionsMenu(menu);
                break;
        }
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter mainAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mainAdapter.addFrag(BlankFragment.newInstance(), "Nổi bật");
        mainAdapter.addFrag(BlankFragment.newInstance(), "Chương trình khuyến mại");
        mainAdapter.addFrag(DienTuFragment.newInstance(), "Điện tử");
        mainAdapter.addFrag(BlankFragment.newInstance(), "Nhà cửa & đời sống");
        mainAdapter.addFrag(BlankFragment.newInstance(), "Mẹ và bé");
        mainAdapter.addFrag(BlankFragment.newInstance(), "Làm đẹp");
        mainAdapter.addFrag(BlankFragment.newInstance(), "Thời trang");
        mainAdapter.addFrag(BlankFragment.newInstance(), "Làm đẹp");
        viewPager.setAdapter(mainAdapter);
    }

    @Override
    public void hienthiMenu(ArrayList<LoaiSanPham> sanPhams) {
        ExpandableAdapter expandableAdapter = new ExpandableAdapter(
                MainActivity.this, sanPhams);
        navigationListView.setAdapter(expandableAdapter);
    }

    @Override
    public void hienthiUserFacebook(AccessToken accessToken) {
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            userName = object.getString("name");
//                            if (menu != null) {
                            setProfileUser(userName);
//                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void setProfileUser(String userName) {
        //set tên user
        loginItem.setEnabled(false);
        SpannableString string = new SpannableString("Xin chào " + userName + "!");
        string.setSpan(new ForegroundColorSpan(ContextCompat.getColor(MainActivity.this, R.color.bgLogo)), 0, string.length(), 0);
        loginItem.setTitle(string);
        //set icon user
        loginItem.setIcon(R.drawable.ic_account_circle_black_24dp);
        LogManager.e(MainActivity.this, userName);
        logoutItem.setVisible(true);
    }

}
