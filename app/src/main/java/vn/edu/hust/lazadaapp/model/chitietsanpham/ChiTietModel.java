package vn.edu.hust.lazadaapp.model.chitietsanpham;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.model.entity.ChiTietSanPham;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.trangchu.dientu.DienTuModel;
import vn.edu.hust.lazadaapp.network.DownloadJSON;

/**
 * Created by HaoLV on 1/8/2018.
 */

public class ChiTietModel {
    public SanPham getChiTietSanPham(String maSanPham) {
        SanPham sanPham = new SanPham();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "laySanPhamVsChitietTheoMaSP");
        hashMaps.add(functionHashMap);

        HashMap<String, String> maSPHashMap = new HashMap<>();
        maSPHashMap.put("masp", maSanPham);
        hashMaps.add(maSPHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("CHITIETSANPHAM");
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);

            sanPham.setMaSanPham(Integer.parseInt(jsonObject1.getString("MASP")));
            sanPham.setTenSanPham(jsonObject1.getString("TENSP"));
            sanPham.setGia(Integer.parseInt(jsonObject1.getString("GIATIEN")));
            sanPham.setSoLuong(Integer.parseInt(jsonObject1.getString("SOLUONG")));
            sanPham.setAnhNho(jsonObject1.getString("ANHNHO"));
            sanPham.setThongTin(jsonObject1.getString("THONGTIN"));
            sanPham.setMaLoaiSanPham(Integer.parseInt(jsonObject1.getString("MALOAISP")));
            sanPham.setMaThuongHieu(Integer.parseInt(jsonObject1.getString("MATHUONGHIEU")));
            sanPham.setMaNhanVien(Integer.parseInt(jsonObject1.getString("MANV")));
            sanPham.setKhuyenMai(jsonObject1.getInt("PHANTRAMKM"));
            sanPham.setTenNhanVien(jsonObject1.getString("TENNV"));
            sanPham.setLuotMua(Integer.parseInt(jsonObject1.getString("LUOTMUA")));
            sanPham.setChiTietList(ChiTietSanPham.getChiTietSanPham(jsonObject1.getJSONArray("THONGSOKYTHUAT")));


        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return sanPham;
    }
}
