package vn.edu.hust.lazadaapp.presenter.danhmuc;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.model.danhmuc.DanhMucModel;
import vn.edu.hust.lazadaapp.model.entity.NhanVien;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.trangchu.dientu.DienTuModel;
import vn.edu.hust.lazadaapp.presenter.dangki.DangKyPresenterInterface;
import vn.edu.hust.lazadaapp.view.danhmuc.SanPhamDanhMucView;

/**
 * Created by HaoLV on 1/3/2018.
 */

public class DanhMucPresenter implements DanhMucPresenterInterface {
    private DanhMucModel danhMucModel;
    private SanPhamDanhMucView view;

    public DanhMucPresenter(SanPhamDanhMucView view) {
        this.view = view;
        danhMucModel = new DanhMucModel();
    }

    @Override
    public void laySanPhamTheoDanhMuc(int maLoaiSanPham, int limit) {
        ArrayList<SanPham> sanphamDanhMucList;
        sanphamDanhMucList = danhMucModel.getDanhMuc(maLoaiSanPham, limit);
        view.hienThiSanPhamTheoDanhMuc(sanphamDanhMucList);
    }
}
