package vn.edu.hust.lazadaapp.model.danhmuc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.network.DownloadJSON;

/**
 * Created by HaoLV on 1/3/2018.
 */

public class DanhMucModel {
    public ArrayList<SanPham> getDanhMuc(int maLoaiSanPham, int limit) {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachSanPhamTheoMaThuongHieu");
        hashMaps.add(functionHashMap);

        HashMap<String, String> maloaiHashMap = new HashMap<>();
        maloaiHashMap.put("maloaisp", String.valueOf(maLoaiSanPham));
        hashMaps.add(maloaiHashMap);

        HashMap<String, String> limitHashMap = new HashMap<>();
        limitHashMap.put("limit", String.valueOf(limit));
        hashMaps.add(limitHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("DANHSACHSANPHAM");
            for (int i = 0; i < jsonArray.length(); i++) {
                SanPham sanPham = new SanPham(jsonArray.getJSONObject(i));
                sanPhams.add(sanPham);
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }
}
