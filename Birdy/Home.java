package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    ConstraintLayout mainLayout;
    FragmentContainerView fragmentContainerView, fragmentContainerView2;
    ImageView imageView, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mainLayout = findViewById(R.id.main_layout);
        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        fragmentContainerView2 = findViewById(R.id.fragmentContainerView2);
        mainLayout.removeView(fragmentContainerView);
        mainLayout.removeView(fragmentContainerView2);

        imageView = findViewById(R.id.vector_ek1);
        imageView2 = findViewById(R.id.vector_ek2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragmentContainerView.isAttachedToWindow()){
                    mainLayout.removeView(fragmentContainerView);
                }else {
                    mainLayout.addView(fragmentContainerView);
                }
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragmentContainerView2.isAttachedToWindow()){
                    mainLayout.removeView(fragmentContainerView2);
                }else {
                    mainLayout.addView(fragmentContainerView2);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        return;
    }
}