package com.example.yohta.androidjavasample.Game;

import com.example.yohta.androidjavasample.Game.Scene.SceneTitle;
import com.example.yohta.androidjavasample.Lib.GameScene;
import com.example.yohta.androidjavasample.Lib.Global;
import com.example.yohta.androidjavasample.Lib.Graphic2D;

import javax.microedition.khronos.opengles.GL10;

public class SceneManager extends GameScene
{
    private SceneTitle      m_SceneTitle = new SceneTitle();

    @Override
    public void Initialize()
    {
        m_SceneTitle.Initialize();
        m_SceneTitle.setInitialized();
    }

    @Override
    public void Update()
    {
        m_SceneTitle.Update();
    }

    @Override
    public void Draw( GL10 gl )
    {
        m_SceneTitle.Draw(gl);
    }
}
