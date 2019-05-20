package com.example.wan_android.util;
import android.util.Log;

import com.example.wan_android.base.Constants;


/**
 * Created by asus on 2019/3/5.
 */

public class Logger {
    public static void logD(String tag,String msg){
        if (Constants.isDebug){
            Log.d(tag, "logD: "+msg);
        }
    }
    public static void println(String msg){
        if (Constants.isDebug){
            System.out.println(msg);
        }
    }

    public static void print(String msg){
        if (Constants.isDebug){
            System.out.println(msg);
        }
    }
}
