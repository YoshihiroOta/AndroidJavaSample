package com.example.yohta.androidjavasample;

import android.content.Context;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;



public class MyRenderer implements GLSurfaceView.Renderer
{
    private MyGameThread        m_GameThread;
    private Context             m_Context;

    public MyRenderer( Context context, MyGameThread gameThread )
    {
        m_Context       = context;
        m_GameThread    = gameThread;
    }

    @Override
    public void onDrawFrame(GL10 gl)
    {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glDisable(GL10.GL_DEPTH_TEST);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        Graphic2D.drawRect(gl, 0, 0, Global.DrawScreenWidth / 2, Global.DrawScreenHeight / 2, 0.5f, 0.5f, 0.5f, 1.0f);
//        Graphic2D.drawTexture(gl, Global.testTexture, 0, 0, 64, 64);
        Graphic2D.drawTexture( gl, Global.testTexture, 0, 0, 64, 64, 1.0f, 1.0f, 1.0f, 0.5f);
//        Graphic2D.drawTexture( gl, Global.testTexture, 0, 0, 64, 64, 32, 32, 32, 32, 1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        Global.gl = gl;

        //画面の表示領域の指定
        Global.gl.glViewport(0, 0, width, height);

        Global.ScreenWidth  = Global.DrawScreenWidth  = width;
        Global.ScreenHeight = Global.DrawScreenHeight = height;

        Global.DrawScreenWidth  = 720;
        Global.DrawScreenHeight = 960;

        Global.testTexture = Graphic2D.loadTexture( gl, m_Context.getResources(), R.drawable.player );
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
    }
}
