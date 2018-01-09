package vn.edu.hust.lazadaapp.model.trangchu.menu;

import android.os.UserManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.network.DownloadJSON;
import vn.edu.hust.lazadaapp.model.entity.LoaiSanPham;

/**
 * Created by HaoLV on 12/28/2017.
 */

public class MenuModel {
    public static MenuModel instance;

    public MenuModel() {
    }

    public static MenuModel getInstance() {
        if (instance == null) {
            instance = new MenuModel();
        }
        return instance;
    }

    public ArrayList<LoaiSanPham> getJSonMenu(String json) {
        ArrayList<LoaiSanPham> loaiSanPhams = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("LOAISANPHAM");
            for (int i = 0; i < jsonArray.length(); i++) {
                LoaiSanPham loaiSanPham = new LoaiSanPham(jsonArray.getJSONObject(i));
                loaiSanPhams.add(loaiSanPham);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return loaiSanPhams;
    }

    public ArrayList<LoaiSanPham> layDanhSachMenuTheoMa(int maloaisp) {
        ArrayList<LoaiSanPham> sanPhams = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachMenu");
        hashMaps.add(functionHashMap);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("maloaicha", String.valueOf(maloaisp));
        hashMaps.add(hashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            sanPhams = getJSonMenu(data);

            LogManager.e(this, data);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        LogManager.e(MenuModel.this, sanPhams.toString());
        return sanPhams;
    }

}
