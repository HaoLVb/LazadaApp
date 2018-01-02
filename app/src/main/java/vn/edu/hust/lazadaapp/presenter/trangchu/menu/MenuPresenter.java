package vn.edu.hust.lazadaapp.presenter.trangchu.menu;


import com.facebook.AccessToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.model.dangnhap.DangNhapModel;
import vn.edu.hust.lazadaapp.network.DownloadJSON;
import vn.edu.hust.lazadaapp.model.entity.LoaiSanPham;
import vn.edu.hust.lazadaapp.model.trangchu.menu.MenuModel;
import vn.edu.hust.lazadaapp.view.trangchu.MenuView;

/**
 * Created by HaoLV on 12/28/2017.
 */

public class MenuPresenter implements MenuPresentInterface {
    private MenuView menuView;

    public MenuPresenter(MenuView menuView) {
        this.menuView = menuView;
    }

    @Override
    public void layDanhSachMenu() {
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachMenu");
        hashMaps.add(functionHashMap);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("maloaicha", "0");
        hashMaps.add(hashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            MenuModel menuModel = MenuModel.getInstance();
            ArrayList<LoaiSanPham> sanPhams = menuModel.getJSonMenu(data);
            menuView.hienthiMenu(sanPhams);

            LogManager.e(this, data);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void layTokenFacebook() {
        DangNhapModel dangNhapModel = DangNhapModel.getInstance();
        AccessToken token = dangNhapModel.getTokenFacebook();
        if (token != null) {
            menuView.hienthiUserFacebook(token);
        }
    }
}
