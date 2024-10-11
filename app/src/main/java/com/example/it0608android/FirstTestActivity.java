package com.example.it0608android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstTestActivity extends AppCompatActivity {
    public final String TAG = "TAG_ACTIVITY";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_test);
        // ghi log kiem tra thong tin
        Log.i(TAG, "*************** onCreate is Running ******************");
        // anh xa view (tim phan tu ngoai layout view)
        Button btnSecondActivity = findViewById(R.id.btnSecondActivity);
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen sang man hinh activity second
                startActivity(new Intent(getApplicationContext(), SecondTestActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "******************* onStart is Running *******************");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "********************* onResume is Running *******************");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "***************** onPause is running *******************");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "****************** onStop is running ********************");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "****************** onRestart is running ********************");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "****************** onDestroy is running ********************");
    }
}
