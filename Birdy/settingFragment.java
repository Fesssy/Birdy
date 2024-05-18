package com.example.myfirstapp;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class settingFragment extends Fragment {

    View myView;
    MediaPlayer musicService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_setting, container, false);
        ImageView imageView = myView.findViewById(R.id.imageView2);
        musicService = musicservice.mp;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicService.isPlaying()){
                    musicService.pause();
                }
                else{
                    musicService.start();
                }
            }
        });
        return myView;
    }
}