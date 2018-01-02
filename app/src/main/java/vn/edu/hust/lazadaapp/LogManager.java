package vn.edu.hust.lazadaapp;

import android.util.Log;

/**
 * Created by quynb on 6/4/2016.
 */
public class LogManager {
    public static void e(Object name, String content) {
        Log.e(name.getClass().getSimpleName(), content);
    }

    public static void e(Object object, Exception e) {
        Log.e(object.getClass().getSimpleName(), "" + e.getMessage());
        e.printStackTrace();
    }
}
