package vn.edu.hust.lazadaapp.view.chitietsanpham;

import vn.edu.hust.lazadaapp.model.entity.SanPham;

/**
 * Created by HaoLV on 1/8/2018.
 */

public interface ChiTietSanPhamView {
    void hienThiChiTiet(SanPham sanPham);

    void hienThiImageSlider(String[] imageUrl);
}
