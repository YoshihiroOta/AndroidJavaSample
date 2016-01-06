package com.example.yohta.androidjavasample.Game.BackGround;

import com.example.yohta.androidjavasample.Lib.Global;
import com.example.yohta.androidjavasample.Lib.Graphic2D;

import javax.microedition.khronos.opengles.GL10;

public class BackGround
{

    public static class Star
    {
        private int x;
        private int y;
        private int size;
        private int speed;
        private float r;
        private float g;
        private float b;

        public void Initialize()
        {
            x = (int)(Math.random()*720);
            y = (int)(Math.random()*(960+100))-100;
            size = (int)(Math.random()*3)+2;
            speed = (int)(Math.random()*2)+1;
            r = (float) Math.random();
            g = (float) Math.random();
            b = (float) Math.random();
        }

        public void Rest() {
            x = (int) (Math.random() * 720);
            y = (int) (Math.random() * (100)) - 100;
            size = (int) (Math.random() * 3) + 2;
            speed = (int) (Math.random() * 2) + 1;
            r = (float) Math.random();
            g = (float) Math.random();
            b = (float) Math.random();
        }

        public void Update()
        {
            y += speed;
            if ( y > 960 ) Rest();
        }

        public void Draw( GL10 gl )
        {
            Graphic2D.drawRect(gl, x, y, size, size, 0.0f, r, g, b, 1.0f);
        }
    }

    private static final int    STAR_NUM = 64;

    private static BackGround   instance = new BackGround();

    private static Star[] m_Stars = new Star[STAR_NUM];

    private BackGround()
    {
    }
    public static BackGround getInstance()
    {
        return instance;
    }

    public static void Initialize()
    {
        for (int i=0; i<STAR_NUM; i++)
        {
            m_Stars[i] = new Star();
            m_Stars[i].Initialize();
        }
    }

    public static void Update()
    {
        for (int i=0; i<STAR_NUM; i++)
        {
            m_Stars[i].Update();
        }
    }

    public static void Draw( GL10 gl )
    {
        for (int i=0; i<STAR_NUM; i++)
        {
            m_Stars[i].Draw(gl);
        }
    }
}
