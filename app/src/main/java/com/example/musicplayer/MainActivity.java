package com.example.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    ImageButton playButton,pauseButton;
    TextView startTime, endTime;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.play);
        pauseButton = findViewById(R.id.pause);
        startTime = findViewById(R.id.starter);
        endTime = findViewById(R.id.ender);
        seekBar = findViewById(R.id.SB);
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
                music.stop();
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
}