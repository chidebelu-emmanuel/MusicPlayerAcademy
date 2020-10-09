package com.example.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    ImageButton playButton,pauseButton;
    TextView start,stop;
    SeekBar seekBar;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.play);
        pauseButton = findViewById(R.id.pause);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        seekBar = findViewById(R.id.progress);
        mHandler = new Handler();
        getSupportActionBar();
        music = MediaPlayer.create(this, R.raw.jesus);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.INVISIBLE);
                music.start();
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playButton.setVisibility(View.VISIBLE);

                pauseButton.setVisibility(View.INVISIBLE);
                music.pause();
            }
        });
       MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mHandler.postDelayed(mRunnable,1000);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.musicmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(this, "share botton ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.head:
                Toast.makeText(this, "headphone botton ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sleep:
                Toast.makeText(this, "sleep botton ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edit:
                Toast.makeText(this, "edit botton ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.song:
                Toast.makeText(this, "song botton ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.queue:
                Toast.makeText(this, "queue opeining ", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (music != null) {
                int currentPosition = music.getCurrentPosition() / 1000;
                seekBar.setProgress(currentPosition);
            }
            mHandler.postDelayed(this,100);
        }
    };
}