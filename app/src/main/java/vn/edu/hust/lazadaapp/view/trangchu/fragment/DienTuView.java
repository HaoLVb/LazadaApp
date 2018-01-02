package vn.edu.hust.lazadaapp.view.trangchu.fragment;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;

/**
 * Created by HaoLV on 1/2/2018.
 */

public interface DienTuView {
    void hienThiThuongHieu(ArrayList<ThuongHieu> thuongHieus, ArrayList<SanPham> sanPhams);
}
