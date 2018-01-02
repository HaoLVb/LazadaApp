package vn.edu.hust.lazadaapp.model.entity;

/**
 * Created by HaoLV on 1/1/2018.
 */

public class NhanVien {
    private String tenNhanVien;
    private String tenDangNhap;
    private String matkhau;
    private String diachi;
    private String ngaysinh;
    private String sdt;
    private int gioitinh;
    private int maLoaiNhanVien;
    private String emailDocQuyen;

    public NhanVien() {
    }

    public NhanVien(String tenNhanVien, String tenDangNhap, String matkhau, String diachi,
                    String ngaysinh, String sdt, int gioitinh, int maLoaiNhanVien, String emailDocQuyen) {
        this.tenNhanVien = tenNhanVien;
        this.tenDangNhap = tenDangNhap;
        this.matkhau = matkhau;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.maLoaiNhanVien = maLoaiNhanVien;
        this.emailDocQuyen = emailDocQuyen;
    }

    public NhanVien(String tenNhanVien, String tenDangNhap, String matkhau, int maLoaiNhanVien, String emailDocQuyen) {
        this.tenNhanVien = tenNhanVien;
        this.tenDangNhap = tenDangNhap;
        this.matkhau = matkhau;
        this.maLoaiNhanVien = maLoaiNhanVien;
        this.emailDocQuyen = emailDocQuyen;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getMaLoaiNhanVien() {
        return maLoaiNhanVien;
    }

    public void setMaLoaiNhanVien(int maLoaiNhanVien) {
        this.maLoaiNhanVien = maLoaiNhanVien;
    }

    public String getEmailDocQuyen() {
        return emailDocQuyen;
    }

    public void setEmailDocQuyen(String emailDocQuyen) {
        this.emailDocQuyen = emailDocQuyen;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "tenNhanVien='" + tenNhanVien + '\'' +
                ", tenDangNhap='" + tenDangNhap + '\'' +
                ", matkhau='" + matkhau + '\'' +
                ", maLoaiNhanVien=" + maLoaiNhanVien +
                ", emailDocQuyen='" + emailDocQuyen + '\'' +
                '}';
    }
}
