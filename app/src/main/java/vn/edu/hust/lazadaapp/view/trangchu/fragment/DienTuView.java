package vn.edu.hust.lazadaapp.view.trangchu.fragment;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;

/**
 * Created by HaoLV on 1/2/2018.
 */

public interface DienTuView {
    void hienThiCacThuongHieuLon(ArrayList<ThuongHieu> thuongHieus);

    void hienthiTopDienThoai(ArrayList<SanPham> dienthoaiList);

    void hienThiDanhSachPhuKien(ArrayList<ThuongHieu> phuKienList);

    void hienThiDanhSachTivi(ArrayList<SanPham> tiviList);

    void hienThiDanhSachTienIch(ArrayList<ThuongHieu> tienIchList);

    void hienThiDanhSachTopMayAnh(ArrayList<SanPham> mayAnhList);

    void hienThiDanhSachHangMoi(ArrayList<SanPham> hangMoiList);

    void hienThiDanhSachLogoThuongHieu(ArrayList<ThuongHieu> logoList);
}
