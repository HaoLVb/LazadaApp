package vn.edu.hust.lazadaapp.model.trangchu.dientu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.model.entity.LoaiSanPham;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;
import vn.edu.hust.lazadaapp.model.trangchu.menu.MenuModel;
import vn.edu.hust.lazadaapp.network.DownloadJSON;

/**
 * Created by HaoLV on 1/1/2018.
 */

public class DienTuModel {
    public static DienTuModel instance;

    public DienTuModel() {
    }

    public static DienTuModel getInstance() {
        if (instance == null) {
            instance = new DienTuModel();
        }
        return instance;
    }


    public ArrayList<SanPham> getJsonTopDienThoai() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachTopDienThoaiVaMayTinhBang");
        hashMaps.add(functionHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("TOPDIENTHOAI&MAYTINHBANG");
            for (int i = 0; i < jsonArray.length(); i++) {
                SanPham sanPham = new SanPham(jsonArray.getJSONObject(i));
                sanPhams.add(sanPham);
            }

            LogManager.e(DienTuModel.this, sanPhams.toString());
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    public ArrayList<ThuongHieu> getJsonPhuKien() {
        ArrayList<ThuongHieu> thuongHieus = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachPhuKien");
        hashMaps.add(functionHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("DANHSACHPHUKIEN");
            for (int i = 0; i < jsonArray.length(); i++) {
                ThuongHieu thuongHieu = new ThuongHieu(jsonArray.getJSONObject(i));
                thuongHieus.add(thuongHieu);
            }

            LogManager.e(this, data);
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return thuongHieus;
    }

    public ArrayList<SanPham> getJsonTopTivi() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachTopPhuKien");
        hashMaps.add(functionHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("TOPPHUKIEN");
            for (int i = 0; i < jsonArray.length(); i++) {
                SanPham sanPham = new SanPham(jsonArray.getJSONObject(i));
                sanPhams.add(sanPham);
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    public ArrayList<ThuongHieu> getJsonTienIch() {
        ArrayList<ThuongHieu> thuongHieus = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachTienIch");
        hashMaps.add(functionHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("DANHSACHTIENICH");
            for (int i = 0; i < jsonArray.length(); i++) {
                ThuongHieu thuongHieu = new ThuongHieu(jsonArray.getJSONObject(i));
                thuongHieus.add(thuongHieu);
            }

            LogManager.e(this, data);
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return thuongHieus;
    }

    public ArrayList<SanPham> getJsonTopMayAnh() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layTopTienIch");
        hashMaps.add(functionHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("TOPTIENICH");
            for (int i = 0; i < jsonArray.length(); i++) {
                SanPham sanPham = new SanPham(jsonArray.getJSONObject(i));
                sanPhams.add(sanPham);
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    public ArrayList<ThuongHieu> getJsonThuongHieuLon() {
        ArrayList<ThuongHieu> thuongHieus = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachCacThuongHieuLon");
        hashMaps.add(functionHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("DANHSACHTHUONGHIEU");
            for (int i = 0; i < jsonArray.length(); i++) {
                ThuongHieu thuongHieu = new ThuongHieu(jsonArray.getJSONObject(i));
                thuongHieus.add(thuongHieu);
            }

            LogManager.e(this, data);
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return thuongHieus;
    }

    public ArrayList<SanPham> getJsonHangMoi() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layDanhSachSanPhamMoi");
        hashMaps.add(functionHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("DANHSACHSANPHAMMOIVE");
            for (int i = 0; i < jsonArray.length(); i++) {
                SanPham sanPham = new SanPham(jsonArray.getJSONObject(i));
                sanPhams.add(sanPham);
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    public ArrayList<ThuongHieu> getJsonLogoThuongHieu() {
        ArrayList<ThuongHieu> thuongHieus = new ArrayList<>();
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "layLogoThuongHieuLon");
        hashMaps.add(functionHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("DANHSACHTHUONGHIEU");
            for (int i = 0; i < jsonArray.length(); i++) {
                ThuongHieu thuongHieu = new ThuongHieu(jsonArray.getJSONObject(i));
                thuongHieus.add(thuongHieu);
            }

            LogManager.e(this, data);
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }
        return thuongHieus;
    }
}
