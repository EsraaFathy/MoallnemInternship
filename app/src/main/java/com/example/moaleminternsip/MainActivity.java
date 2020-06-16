package com.example.moaleminternsip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VedioAdapter.ViewHolder.OnVideoListener {

    private List<Model> modelList;
    private List<VedioModel> modelListVedio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillData();
        fillDataVedio();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewSubjects);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, modelList);
        recyclerView.setAdapter(recyclerAdapter);

        RecyclerView recyclerViewVideo = findViewById(R.id.recyclerVideo);
        LinearLayoutManager linearLayoutManagerVedio =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewVideo.setLayoutManager(linearLayoutManagerVedio);
        recyclerViewVideo.setHasFixedSize(true);
        VedioAdapter recyclerAdapterVideo = new VedioAdapter(this, modelListVedio,this);
        recyclerViewVideo.setAdapter(recyclerAdapterVideo);

    }

    private void fillData() {
        int[] images = {R.drawable.physics,
                R.drawable.biology,
                R.drawable.history,
                R.drawable.algebra};

        String[] names = {"Physics", "Biology", "History", "Algebra"};

        modelList = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            modelList.add(new Model(images[i], names[i]));
        }
    }


    private void fillDataVedio() {
        int[] images = {R.raw.welcome,R.raw.exercise_files};

        String[] names = {"welcome","files"};
        int[] background={R.drawable.video_background,R.drawable.fille};

        modelListVedio = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            modelListVedio.add(new VedioModel(images[i], names[i],background[i]));
        }
    }

    @Override
    public void onVideoClick(int position) {
        VedioModel vedioModel=modelListVedio.get(position);
        int i = vedioModel.getImage();
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("i",i);
        intent.putExtra("title",vedioModel.getSubject());
        startActivity(intent);
    }
}
//LinearLayoutManager layoutManager
//    = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//
//RecyclerView myList = (RecyclerView) findViewById(R.id.my_recycler_view);
//myList.setLayoutManager(layoutManager);


//<?xml version="1.0" encoding="utf-8"?>
//<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//    xmlns:app="http://schemas.android.com/apk/res-auto"
//    android:layout_width="wrap_content"
//    android:paddingHorizontal="10dp"
//    android:layout_height="wrap_content"
//    android:orientation="vertical">
//
//    <androidx.cardview.widget.CardView
//        android:layout_width="150dp"
//        android:layout_height="150dp"
//        android:layout_margin="8dp"
//        app:cardBackgroundColor="@color/colorPrimaryDark"
//        app:cardCornerRadius="30dp">
//
//        <ImageView
//            android:id="@+id/imageItemDesign"
//            android:layout_width="50dp"
//            android:layout_height="50dp"
//            android:layout_gravity="center"
//            android:contentDescription="@string/subject_logo"
//            android:src="@drawable/physics" />
//    </androidx.cardview.widget.CardView>
//
//    <TextView
//        android:id="@+id/textItemDesign"
//        android:layout_width="150dp"
//        android:layout_height="70dp"
//        android:gravity="center"
//        android:text="@string/physics"
//        android:fontFamily="sans-serif-condensed-medium"
//        android:textColor="@color/colorPrimary"
//        android:textSize="20sp" />
//</LinearLayout>