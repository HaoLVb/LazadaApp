package vn.edu.hust.lazadaapp.model.entity;

import java.util.ArrayList;

/**
 * Created by HaoLV on 1/2/2018.
 */

public class DienTu {
    private String hinhAnh;
    private ArrayList<ThuongHieu> thuongHieus;
    private ArrayList<SanPham> sanPhams;

    public DienTu() {
    }

    public DienTu(String hinhAnh, ArrayList<ThuongHieu> thuongHieus, ArrayList<SanPham> sanPhams) {
        this.hinhAnh = hinhAnh;
        this.thuongHieus = thuongHieus;
        this.sanPhams = sanPhams;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public ArrayList<ThuongHieu> getThuongHieus() {
        return thuongHieus;
    }

    public void setThuongHieus(ArrayList<ThuongHieu> thuongHieus) {
        this.thuongHieus = thuongHieus;
    }

    public ArrayList<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(ArrayList<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
}
