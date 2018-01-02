package vn.edu.hust.lazadaapp.model.dangky;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.model.entity.NhanVien;
import vn.edu.hust.lazadaapp.model.trangchu.menu.MenuModel;
import vn.edu.hust.lazadaapp.network.DownloadJSON;

/**
 * Created by HaoLV on 1/1/2018.
 */

public class DangKyModel {
    public String dangKyThanhVien(NhanVien nhanVien) {
        String data = null;
        String result=null;
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "dangKyThanhVien");
        hashMaps.add(functionHashMap);

        HashMap<String, String> tenNhanVienHashMap = new HashMap<>();
        tenNhanVienHashMap.put("tennv", nhanVien.getTenNhanVien());
        hashMaps.add(tenNhanVienHashMap);

        HashMap<String, String> tenDangNhapHashMap = new HashMap<>();
        tenDangNhapHashMap.put("tendangnhap", nhanVien.getTenDangNhap());
        hashMaps.add(tenDangNhapHashMap);

        HashMap<String, String> matKhauHashMap = new HashMap<>();
        matKhauHashMap.put("matkhau", nhanVien.getMatkhau());
        hashMaps.add(matKhauHashMap);

        HashMap<String, String> loaiNhanVienHashMap = new HashMap<>();
        loaiNhanVienHashMap.put("maloainv", String.valueOf(nhanVien.getMaLoaiNhanVien()));
        hashMaps.add(loaiNhanVienHashMap);

        HashMap<String, String> emailHashMap = new HashMap<>();
        emailHashMap.put("emaildocquyen", nhanVien.getEmailDocQuyen());
        hashMaps.add(emailHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
             result = jsonObject.getString("ketqua");
            LogManager.e(this, result);
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
            LogManager.e(this, e);
        }
        return result ;
    }
}
