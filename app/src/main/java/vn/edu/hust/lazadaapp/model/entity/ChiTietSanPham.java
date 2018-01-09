package vn.edu.hust.lazadaapp.model.entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by HaoLV on 1/8/2018.
 */

public class ChiTietSanPham {
    private String tenChiTiet;
    private String giaTri;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String tenChiTiet, String giaTri) {
        this.tenChiTiet = tenChiTiet;
        this.giaTri = giaTri;
    }

    public static ArrayList<ChiTietSanPham> getChiTietSanPham(JSONArray jsonArray) {
        ArrayList<ChiTietSanPham> chiTietSanPhams = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                for (int j = 0; j < jsonObject.names().length(); j++) {
                    ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
                    chiTietSanPham.setTenChiTiet(jsonObject.names().getString(j));
                    chiTietSanPham.setGiaTri(jsonObject.getString(jsonObject.names().getString(j)));
                    chiTietSanPhams.add(chiTietSanPham);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return chiTietSanPhams;
    }

    public String getTenChiTiet() {
        return tenChiTiet;
    }

    public void setTenChiTiet(String tenChiTiet) {
        this.tenChiTiet = tenChiTiet;
    }

    public String getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(String giaTri) {
        this.giaTri = giaTri;
    }

    @Override
    public String toString() {
        return "ChiTietSanPham{" +
                "tenChiTiet='" + tenChiTiet + '\'' +
                ", giaTri='" + giaTri + '\'' +
                '}';
    }
}
