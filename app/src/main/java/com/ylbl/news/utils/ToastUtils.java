package com.ylbl.news.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    public static void toastShort(Context context , String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
    public static void toastLong(Context context , String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
