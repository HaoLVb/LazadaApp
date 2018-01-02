package vn.edu.hust.lazadaapp.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by HaoLV on 12/28/2017.
 */

public class LoaiSanPham {
    private int maLoaiSp;
    private int maLoaiCha;
    private String tenLoaiSp;
    private ArrayList<LoaiSanPham> sanPhams;

    public LoaiSanPham() {
    }

    public LoaiSanPham(int maLoaiSp, int maLoaiCha, String tenLoaiSp, ArrayList<LoaiSanPham> sanPhams) {
        this.maLoaiSp = maLoaiSp;
        this.maLoaiCha = maLoaiCha;
        this.tenLoaiSp = tenLoaiSp;
        this.sanPhams = sanPhams;
    }

    public LoaiSanPham(JSONObject jsonObject) {
        try {
            this.maLoaiCha = Integer.parseInt(jsonObject.getString("MALOAI_CHA"));
            this.maLoaiSp = Integer.parseInt(jsonObject.getString("MALOAISP"));
            this.tenLoaiSp = jsonObject.getString("TENLOAISP");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getMaLoaiSp() {
        return maLoaiSp;
    }

    public void setMaLoaiSp(int maLoaiSp) {
        this.maLoaiSp = maLoaiSp;
    }

    public int getMaLoaiCha() {
        return maLoaiCha;
    }

    public void setMaLoaiCha(int maLoaiCha) {
        this.maLoaiCha = maLoaiCha;
    }

    public String getTenLoaiSp() {
        return tenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        this.tenLoaiSp = tenLoaiSp;
    }

    public ArrayList<LoaiSanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(ArrayList<LoaiSanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    @Override
    public String toString() {
        return "LoaiSanPham{" +
                "maLoaiSp=" + maLoaiSp +
                ", maLoaiCha=" + maLoaiCha +
                ", tenLoaiSp='" + tenLoaiSp + '\'' +
                ", sanPhams=" + sanPhams +
                '}';
    }
}
