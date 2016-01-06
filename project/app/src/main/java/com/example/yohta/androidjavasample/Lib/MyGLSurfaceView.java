package com.example.yohta.androidjavasample.Lib;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 * Created by yohta on 2015/12/14.
 */
public class MyGLSurfaceView extends GLSurfaceView
{
    private MyGLSurfaceView     m_GameThread;

    public MyGLSurfaceView( Context context, MyGameThread gameThread )
    {
        super( context );
        setFocusable(true);
        m_GameThread = m_GameThread;
    }

    @Override
    public boolean onTouchEvent( MotionEvent event )
    {
        float wratio = (float) Global.DrawScreenWidth  / (float) Global.ScreenWidth;
        float hratio = (float) Global.DrawScreenHeight / (float) Global.ScreenHeight;

        switch ( event.getAction() )
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                Global.isTouch = true;
                Global.TouchX = (int) ( event.getX() * wratio );
                Global.TouchY = (int) ( event.getY() * hratio );
                break;
            default:
                Global.isTouch = false;
                break;
        }
        return true;
    }
}
