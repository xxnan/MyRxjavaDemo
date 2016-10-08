package com.android.xxnan.myrxjavademo.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by xxnan on 2016/10/8.
 */
public class RxJavaUtil {
    /**
     * 根据图片地址从网络上获取bitmap
     * @param path
     * @return
     */
    public static Bitmap getBitMapFromIntent(String path) {
        Bitmap bitmap = null;
        URL imgUrl = null;
        try {
            imgUrl = new URL(path);
            // 使用HttpURLConnection打开连接
            HttpURLConnection urlConn = (HttpURLConnection) imgUrl
                    .openConnection();
            urlConn.setDoInput(true);
            urlConn.connect();
            // 将得到的数据转化成InputStream
            InputStream is = null;
            is = urlConn.getInputStream();

            // 将InputStream转换成Bitmap
            bitmap = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
