package vn.edu.hust.lazadaapp.presenter.chitietsanpham;

import vn.edu.hust.lazadaapp.model.chitietsanpham.ChiTietModel;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.view.chitietsanpham.ChiTietSanPhamView;

/**
 * Created by HaoLV on 1/8/2018.
 */

public class ChiTietPresenter {
    private ChiTietSanPhamView chiTietSanPhamView;
    private ChiTietModel chiTietModel;

    public ChiTietPresenter(ChiTietSanPhamView chiTietSanPhamView) {
        this.chiTietSanPhamView = chiTietSanPhamView;
        chiTietModel = new ChiTietModel();
    }

    public void getChiTietSanPham(String maSanPham) {
        SanPham sanPham = chiTietModel.getChiTietSanPham(maSanPham);
        chiTietSanPhamView.hienThiChiTiet(sanPham);
        chiTietSanPhamView.hienThiImageSlider(sanPham.getAnhNho().split(","));

    }
}
