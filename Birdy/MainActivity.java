package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    ProgressBar progressBar;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        con_videoView();
        con_progressBar();
        startService(new Intent(this, musicservice.class));
    }

    public void con_videoView(){
        videoView = findViewById(R.id.videoview);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.logovideo;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();
    }

    public void con_progressBar(){

        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter+=5;
                progressBar.setProgress(counter);
                if (counter == 100){
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    t.cancel();
                    navigateToHome();
                }
            }
        };
        t.schedule(tt, 0, 100);
    }

    public void navigateToHome(){
        startActivity(new Intent(this, Home.class));
    }

}