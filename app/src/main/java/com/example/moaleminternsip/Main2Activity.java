package com.example.moaleminternsip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {
VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        videoView=findViewById(R.id.videoView);

        Intent intent=getIntent();
        int i=intent.getIntExtra("i",0);
        String title=intent.getStringExtra("title");

        setTitle(title);

        if ( videoView!= null){
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + i);
        }


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();
    }
}
