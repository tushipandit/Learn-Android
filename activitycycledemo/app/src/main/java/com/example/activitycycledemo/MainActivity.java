package com.example.activitycycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("life cycle event" ,"onCreate" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life cycle event","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("life cycle event","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life cycle event","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life cycle event","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life cycle event","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life cycle event","onRestart");
    }
}
//all methods are the activity life cycle basic mehods
//all methods are automatically defined by the activity
//we alter the methods for various purposes like memory management , multi-tasking etc.