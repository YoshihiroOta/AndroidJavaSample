package com.example.yohta.androidjavasample;

import java.util.ArrayList;

/**
 * Created by yohta on 2015/12/17.
 */
public class TextureManager
{
    public class Texture
    {
        public int         textureNo;
        public int         width;
        public int         height;

        public Texture( int no, int w, int h )
        {
            textureNo   = no;
            width        = w;
            height      = h;
        }
    }

    private ArrayList<Texture> TextureList = new ArrayList();

    public int getNextNo()
    {
        return TextureList.size();
    }

    public void addTexture( int texno, int w, int h )
    {
        TextureList.add( new Texture( texno, w, h ) );
    }

    public int getTextureNo( int no ) { return TextureList.get(no).textureNo; }
    public int getWidth( int no )     { return TextureList.get(no).width; }
    public int getHeight( int no )    { return TextureList.get(no).height; }

}
