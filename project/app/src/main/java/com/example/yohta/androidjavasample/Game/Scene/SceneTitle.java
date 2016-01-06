package com.example.yohta.androidjavasample.Game.Scene;

import com.example.yohta.androidjavasample.Game.BackGround.BackGround;
import com.example.yohta.androidjavasample.Lib.GameScene;
import com.example.yohta.androidjavasample.Lib.Global;
import com.example.yohta.androidjavasample.Lib.Graphic2D;

import javax.microedition.khronos.opengles.GL10;

public class SceneTitle extends GameScene
{
    public float angle = 0.0f;

    public int x, y;

    @Override
    public void Initialize()
    {
        BackGround.getInstance().Initialize();

        x = Global.DrawScreenWidth/2-32;
        y = (Global.DrawScreenHeight/3)*2-32;
    }

    @Override
    public void Update()
    {
        if ( !isInitializd() ) return;

        BackGround.getInstance().Update();

        if ( Global.isTouch )
        {
            x = Global.TouchX - (64/2);
            y = Global.TouchY - 96;
        }
    }

    @Override
    public void Draw( GL10 gl )
    {
        if ( !isInitializd() ) return;

        BackGround.getInstance().Draw(gl);
        Graphic2D.drawTexture( gl, Global.testTexture, x, y, 64, 64, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f);
    }
}
