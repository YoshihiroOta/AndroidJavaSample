package com.example.yohta.androidjavasample;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by yohta on 2015/12/14.
 */
public class MyGLSurfaceView extends GLSurfaceView
{
    private MyGLSurfaceView     m_GameThread;

    public MyGLSurfaceView( Context context, MyGameThread gameThread )
    {
        super( context );
        m_GameThread = m_GameThread;
    }
}
