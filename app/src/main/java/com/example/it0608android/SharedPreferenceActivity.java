package com.example.it0608android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferenceActivity extends AppCompatActivity {
    EditText edtNumber1, edtNumber2, edtResult;
    Button btnCalculate, btnCancel, btnGoHome;
    TextView tvHistory;
    private String history = "";

    @Override
    protected void onPause() {
        super.onPause();
        // xu ly luu du lieu vao shared preferences
        SharedPreferences myPrefs = getSharedPreferences("calculateMaths", MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        editor.putString("HistoryMaths", history);
        editor.apply();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        edtNumber1 = findViewById(R.id.edtNumber_1);
        edtNumber2 = findViewById(R.id.edtNumber_2);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCancel = findViewById(R.id.btnCancel);
        btnGoHome = findViewById(R.id.btnGoHome);
        tvHistory = findViewById(R.id.tvHistory);
        edtResult = findViewById(R.id.edtResult);
        edtResult.setEnabled(false);// block input

        // doc du lieu tu Shared Preferences
        SharedPreferences sharePrefs = getSharedPreferences("calculateMaths", MODE_PRIVATE);
        history = sharePrefs.getString("HistoryMaths", "");
        tvHistory.setText(history);

        btnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedPreferenceActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = Integer.parseInt(edtNumber1.getText().toString().trim());
                int n2 = Integer.parseInt(edtNumber2.getText().toString().trim());
                int result = n1 + n2;
                edtResult.setText(String.valueOf(result));
                history += n1 + " + " + n2 + " = " + result;
                tvHistory.setText(history);
                history += "\n";
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = "";
                tvHistory.setText("");
            }
        });

    }
}
