package vn.edu.hust.lazadaapp.model.dangnhap;

import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import vn.edu.hust.lazadaapp.ApplicationData;
import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.model.trangchu.menu.MenuModel;
import vn.edu.hust.lazadaapp.network.DownloadJSON;

/**
 * Created by HaoLV on 12/31/2017.
 */

public class DangNhapModel {
    private AccessToken token;
    private AccessTokenTracker accessTokenTracker;
    private static DangNhapModel instance;

    public DangNhapModel() {
    }

    public static DangNhapModel getInstance() {
        if (instance == null) {
            instance = new DangNhapModel();
        }
        return instance;
    }


    public AccessToken getTokenFacebook() {

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
                                                       AccessToken currentAccessToken) {
                token = currentAccessToken;
            }


        };
        token = AccessToken.getCurrentAccessToken();
        return token;
    }

    public boolean kiemTraDangNhap(Context context, String username, String password) {
        boolean result = false;
        ArrayList<HashMap<String, String>> hashMaps = new ArrayList<>();

        HashMap<String, String> functionHashMap = new HashMap<>();
        functionHashMap.put("function", "kiemTraDangNhap");
        hashMaps.add(functionHashMap);

        HashMap<String, String> nameHashMap = new HashMap<>();
        nameHashMap.put("tendangnhap", username);
        hashMaps.add(nameHashMap);

        HashMap<String, String> passHashMap = new HashMap<>();
        passHashMap.put("matkhau", password);
        hashMaps.add(passHashMap);

        String url = ApplicationData.DOMAIN + "/loaisanpham.php";
        DownloadJSON downloadJSON = new DownloadJSON(url, hashMaps);
        try {
            String data = downloadJSON.execute().get();
            JSONObject jsonObject = new JSONObject(data);
            result = jsonObject.getBoolean("ketqua");
            LogManager.e(DangNhapModel.this, jsonObject.toString());
            if (result) {
                String tennv = jsonObject.getString("tennv");
                updateCacheLogin(context, tennv);
            }
        } catch (InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }

    public String getCacheLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("dangnhap", Context.MODE_PRIVATE);
        String tennv = sharedPreferences.getString("tennv", "");
        return tennv;
    }

    public void updateCacheLogin(Context context, String tenv) {
        SharedPreferences cachedDangNhap = context.getSharedPreferences("dangnhap", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = cachedDangNhap.edit();
        editor.putString("tennv", tenv);
        editor.commit();
    }

    public void stopTracking() {
        accessTokenTracker.stopTracking();
    }


}
