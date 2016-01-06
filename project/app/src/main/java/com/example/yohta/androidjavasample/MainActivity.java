package com.example.yohta.androidjavasample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yohta.androidjavasample.Game.SceneManager;
import com.example.yohta.androidjavasample.Lib.GameScene;
import com.example.yohta.androidjavasample.Lib.Global;
import com.example.yohta.androidjavasample.Lib.MyGLSurfaceView;
import com.example.yohta.androidjavasample.Lib.MyGameThread;
import com.example.yohta.androidjavasample.Lib.MyRenderer;

public class MainActivity extends AppCompatActivity
{
    private MyGameThread m_GameThread;
    private SceneManager m_SceneManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Global.mainActivity = this;

        m_SceneManager = new SceneManager();

        m_GameThread = new MyGameThread( m_SceneManager );

        MyRenderer renderer             = new MyRenderer( this, m_GameThread );
        MyGLSurfaceView glSurfaceView   = new MyGLSurfaceView( this, m_GameThread );

        glSurfaceView.setRenderer( renderer );
        setContentView(glSurfaceView);

        m_GameThread.start();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
}
