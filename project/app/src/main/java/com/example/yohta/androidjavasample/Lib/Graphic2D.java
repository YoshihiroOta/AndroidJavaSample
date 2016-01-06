package com.example.yohta.androidjavasample.Lib;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class Graphic2D
{
    private static TextureManager texmanager = new TextureManager();

    public static final FloatBuffer makeFloatBuffer( float[] arr )
    {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(arr.length * 4);

        bytebuffer.order(ByteOrder.nativeOrder());

        FloatBuffer floatbuffer = bytebuffer.asFloatBuffer();

        floatbuffer.put(arr);

        floatbuffer.position(0);

        return floatbuffer;
    }

    public static final int loadTexture( GL10 gl, Resources res, int resid )
    {
        int[] textures = new int[1];

        Bitmap bmp = BitmapFactory.decodeResource( res, resid );

        if ( bmp == null ) return 0;

        gl.glGenTextures(1, textures, 0);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);

        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bmp, 0);

        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);

        gl.glBindTexture(GL10.GL_TEXTURE_2D, 0);

        int curtextureno = texmanager.getNextNo();

        texmanager.addTexture(textures[0], bmp.getWidth(), bmp.getHeight());

        bmp.recycle();

        return curtextureno;
    }

    public static final int getTextureNo( int no )
    {
        return texmanager.getTextureNo(no);
    }

    public static final int getTextureWidth( int no )
    {
        return texmanager.getWidth(no);
    }

    public static final int getTextureHeight( int no )
    {
        return texmanager.getHeight(no);
    }

    public static final void drawRect( GL10 gl, int x, int y, int width, int height, float angle, float r, float g, float b, float a )
    {
        float[] vx = new float[4];
        float[] vy = new float[4];

        vx[0] = -((float) width / 2.0f);
        vy[0] = -((float) height / 2.0f);

        vx[1] = -((float) width / 2.0f);
        vy[1] =  ((float) height / 2.0f);

        vx[2] =  ((float) width / 2.0f);
        vy[2] = -((float) height / 2.0f);

        vx[3] =  ((float) width / 2.0f);
        vy[3] =  ((float) height / 2.0f);

        angle = angle * ((float) Math.PI / 180.0f);

        for (int i = 0; i < 4; i++)
        {
            float wkx = (float)Math.cos((double) angle) * vx[i] - (float)Math.sin((double) angle) * vy[i];
            float wky = (float)Math.sin((double) angle) * vx[i] + (float)Math.cos((double) angle) * vy[i];

            vx[i] = wkx;
            vy[i] = wky;

            vx[i] += ( (float) x + (float) width  / 2.0f );
            vy[i] += ( (float) y + (float) height / 2.0f );

            vx[i] = ( vx[i] / (float)Global.DrawScreenWidth)  * 2.0f - 1.0f;
            vy[i] = ( vy[i] / (float)Global.DrawScreenHeight) * 2.0f - 1.0f;
        }

        float[] vertex =
        {
            vx[0], -vy[0],
            vx[1], -vy[1],
            vx[2], -vy[2],
            vx[3], -vy[3]
        };

        float[] color =
        {
            r, g, b, a,
            r, g, b, a,
            r, g, b, a,
            r, g, b, a
        };

        FloatBuffer vertexbuffer = Graphic2D.makeFloatBuffer(vertex);
        FloatBuffer colorbuffer  = Graphic2D.makeFloatBuffer(color);

        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexbuffer);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorbuffer);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

    }

    public static final void drawRect( GL10 gl, int x, int y, int width, int height, float r, float g, float b, float a )
    {
        drawRect( gl, x, y, width, height, 0.0f, r, g, b, a );
    }

    public static final void drawTexture( GL10 gl, int texture, int x, int y, int width, int height, float angle, int u, int v, int texw, int texh,  float r, float g, float b, float a )
    {
        float[] vx = new float[4];
        float[] vy = new float[4];

        vx[0] = -((float) width / 2.0f);
        vy[0] = -((float) height / 2.0f);

        vx[1] = -((float) width / 2.0f);
        vy[1] =  ((float) height / 2.0f);

        vx[2] =  ((float) width / 2.0f);
        vy[2] = -((float) height / 2.0f);

        vx[3] =  ((float) width / 2.0f);
        vy[3] =  ((float) height / 2.0f);

        angle = angle * ((float) Math.PI / 180.0f);

        for (int i = 0; i < 4; i++)
        {
            float wkx = (float)Math.cos((double) angle) * vx[i] - (float)Math.sin((double) angle) * vy[i];
            float wky = (float)Math.sin((double) angle) * vx[i] + (float)Math.cos((double) angle) * vy[i];

            vx[i] = wkx;
            vy[i] = wky;

            vx[i] += ( (float) x + (float) width  / 2.0f );
            vy[i] += ( (float) y + (float) height / 2.0f );

            vx[i] = ( vx[i] / (float)Global.DrawScreenWidth)  * 2.0f - 1.0f;
            vy[i] = ( vy[i] / (float)Global.DrawScreenHeight) * 2.0f - 1.0f;
        }

        float[] vertex =
        {
            vx[0], -vy[0],
            vx[1], -vy[1],
            vx[2], -vy[2],
            vx[3], -vy[3]
        };

        float[] color =
                {
                        r, g, b, a,
                        r, g, b, a,
                        r, g, b, a,
                        r, g, b, a
                };

        float fu = (float)((float)u / (float)texmanager.getWidth(texture) );
        float fv = (float)((float)v / (float)texmanager.getHeight(texture) );
        float ftexw = (float)((float)texw / (float)texmanager.getWidth(texture) );
        float ftexh = (float)((float)texh / (float)texmanager.getHeight(texture) );

        float[] coords =
                {
                        fu, fv,   //頂点0
                        fu, fv + ftexh,   //頂点1
                        fu + ftexw, fv,   //頂点2
                        fu + ftexw, fv + ftexh    //頂点3
                };

        FloatBuffer vertexbuffer  = Graphic2D.makeFloatBuffer(vertex);
        FloatBuffer colorbuffer   = Graphic2D.makeFloatBuffer(color);
        FloatBuffer coordsbuffer  = Graphic2D.makeFloatBuffer(coords);

        gl.glEnable( GL10.GL_TEXTURE_2D );
        gl.glBindTexture(GL10.GL_TEXTURE_2D, texmanager.getTextureNo(texture));

        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexbuffer);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorbuffer);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, coordsbuffer);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisable( GL10.GL_TEXTURE_2D );
    }

    public static final void drawTexture( GL10 gl, int texture, int x, int y, int width, int height )
    {
        drawTexture( gl, texture, x, y, width, height, 0.0f, 0, 0, texmanager.getWidth(texture), texmanager.getHeight(texture), 1.0f, 1.0f, 1.0f, 1.0f );
    }

    public static final void drawTexture( GL10 gl, int texture, int x, int y, int width, int height, float angle )
    {
        drawTexture( gl, texture, x, y, width, height, angle, 0, 0, texmanager.getWidth(texture), texmanager.getHeight(texture), 1.0f, 1.0f, 1.0f, 1.0f );
    }

    public static final void drawTexture( GL10 gl, int texture, int x, int y, int width, int height, float r, float g, float b, float a )
    {
        drawTexture( gl, texture, x, y, width, height, 0.0f, 0, 0, texmanager.getWidth(texture), texmanager.getHeight(texture), r, g, b, a );
    }

    public static final void drawTexture( GL10 gl, int texture, int x, int y, int width, int height, float angle, float r, float g, float b, float a )
    {
        drawTexture( gl, texture, x, y, width, height, angle, 0, 0, texmanager.getWidth(texture), texmanager.getHeight(texture), r, g, b, a );
    }
}
