package vn.edu.hust.lazadaapp.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by HaoLV on 1/1/2018.
 */

public class ThuongHieu {
    private int maThuongHieu;
    private int luotMua;
    private String tenThuongHieu;
    private String hinhThuongHieu;

    public ThuongHieu(int maThuongHieu, int luotMua, String tenThuongHieu, String hinhThuongHieu) {
        this.maThuongHieu = maThuongHieu;
        this.luotMua = luotMua;
        this.tenThuongHieu = tenThuongHieu;
        this.hinhThuongHieu = hinhThuongHieu;
    }

    public ThuongHieu(JSONObject jsonObject) {
        try {
            this.maThuongHieu = Integer.parseInt(jsonObject.getString("MASP"));
            this.luotMua = 0;
            this.tenThuongHieu = jsonObject.getString("TENSP");
            this.hinhThuongHieu = jsonObject.getString("HINHSANPHAM");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public int getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(int maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public int getLuotMua() {
        return luotMua;
    }

    public void setLuotMua(int luotMua) {
        this.luotMua = luotMua;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getHinhThuongHieu() {
        return hinhThuongHieu;
    }

    public void setHinhThuongHieu(String hinhThuongHieu) {
        this.hinhThuongHieu = hinhThuongHieu;
    }
}
