package com.example.yohta.androidjavasample.Lib;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by user on 16/01/05.
 */
public class GameScene
{
    private boolean m_Initialized = false;

    public boolean isInitializd()
    {
        return m_Initialized;
    }

    public void setInitialized()
    {
        m_Initialized = true;
    }

    public void Initialize()
    {
        m_Initialized = true;
    }

    public void Finalize()
    {
    }

    public void Update()
    {
    }

    public void Draw( GL10 gl )
    {
    }
}
