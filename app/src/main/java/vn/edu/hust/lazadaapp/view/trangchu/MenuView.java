package vn.edu.hust.lazadaapp.view.trangchu;

import com.facebook.AccessToken;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.model.entity.LoaiSanPham;

/**
 * Created by HaoLV on 12/28/2017.
 */

public interface MenuView {
    void hienthiMenu(ArrayList<LoaiSanPham> sanPhams);

    void hienthiUserFacebook(AccessToken accessToken);
}
