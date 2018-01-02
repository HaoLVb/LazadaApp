package vn.edu.hust.lazadaapp.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by HaoLV on 1/2/2018.
 */

public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private int gia;
    private String anhLon;
    private String anhNho;
    private String thongTin;
    private int soLuong;
    private int maLoaiSanPham;
    private int maThuongHieu;
    private int maNhanVien;
    private int luotMua;

    public SanPham(int maSanPham, String tenSanPham, int gia, String anhLon, String anhNho,
                   String thongTin, int soLuong, int maLoaiSanPham,
                   int maThuongHieu, int maNhanVien, int luotMua) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.anhLon = anhLon;
        this.anhNho = anhNho;
        this.thongTin = thongTin;
        this.soLuong = soLuong;
        this.maLoaiSanPham = maLoaiSanPham;
        this.maThuongHieu = maThuongHieu;
        this.maNhanVien = maNhanVien;
        this.luotMua = luotMua;
    }

    public SanPham(JSONObject jsonObject) {
        try {
            this.maSanPham = Integer.parseInt(jsonObject.getString("MASP"));
            this.tenSanPham = jsonObject.getString("TENSP");
            this.gia = Integer.parseInt(jsonObject.getString("GIATIEN"));
            this.anhLon = jsonObject.getString("HINHSANPHAM");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getAnhLon() {
        return anhLon;
    }

    public void setAnhLon(String anhLon) {
        this.anhLon = anhLon;
    }

    public String getAnhNho() {
        return anhNho;
    }

    public void setAnhNho(String anhNho) {
        this.anhNho = anhNho;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public int getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(int maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getLuotMua() {
        return luotMua;
    }

    public void setLuotMua(int luotMua) {
        this.luotMua = luotMua;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSanPham=" + maSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", gia=" + gia +
                ", anhLon='" + anhLon + '\'' +
                '}';
    }
}
