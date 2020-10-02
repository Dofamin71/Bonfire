package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);
        final View decorView = getWindow().getDecorView();
        decorView
                .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            decorView.setSystemUiVisibility(flags);
                        }
                    }
                });
        setContentView(new MyView(this));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("RRR", "onDestroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("RRR", "onRestart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("RRR", "onPause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("RRR", "onResume");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("RRR", "onStart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("RRR", "onStop");
    }
}
