package com.example.yohta.androidjavasample.Lib;

import android.content.res.Resources;

import com.example.yohta.androidjavasample.MainActivity;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by yohta on 2015/12/14.
 */
public class Global
{
    public static GL10             gl;

    public static boolean         m_SystemEnable = false;

    public static MainActivity     mainActivity;

    public static int              ScreenWidth;
    public static int              ScreenHeight;

    public static int              DrawScreenWidth;
    public static int              DrawScreenHeight;

    public static int              testTexture;
    public static int              texTitle;

    public static boolean           isTouch;
    public static int               TouchX;
    public static int               TouchY;
}
