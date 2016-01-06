package com.example.yohta.androidjavasample.Lib;

import com.example.yohta.androidjavasample.Lib.Global;
import com.example.yohta.androidjavasample.Lib.Graphic2D;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by yohta on 2015/12/14.
 */
public class MyGameThread extends Thread
{
    private GameScene m_Scene;

    public MyGameThread( GameScene scene )
    {
        m_Scene = scene;
    }

    @Override
    public void run()
    {
        boolean wait_initialize = true;

        long lastUpdateTime = System.currentTimeMillis();

        while (true)
        {
            // sleep
            try
            {
                Thread.sleep(10);
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }

            // 初期化待ち
            if ( wait_initialize )
            {
                if ( Global.m_SystemEnable )
                {
                    m_Scene.Initialize();
                    wait_initialize = false;
                }
                continue;
            }
            // 1/60
            long nowTime = System.currentTimeMillis();
            long difference = nowTime - lastUpdateTime;

            while ( difference >= 17 )
            {
                difference -= 17;
                m_Scene.Update();
            }
            lastUpdateTime = nowTime - difference;
        }
    }

    public void Draw( GL10 gl )
    {
        m_Scene.Draw( gl );
    }
}
