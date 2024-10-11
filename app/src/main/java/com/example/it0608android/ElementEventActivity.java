package com.example.it0608android;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ElementEventActivity extends AppCompatActivity {
    public EditText edtEmail;
    public Button btnSubmit, btnOk;
    public CheckBox cbAgree;
    public RadioButton radMale, radFemale, radLGBT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_elements);

        edtEmail = findViewById(R.id.edtEmail);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnOk = findViewById(R.id.btnOk);
        cbAgree = findViewById(R.id.cbAgree);
        radLGBT = findViewById(R.id.radLGBT);

        btnSubmit.setEnabled(false);
        btnOk.setEnabled(false);

        radLGBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubmit.setEnabled(true);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myEmail = edtEmail.getText().toString().trim();
                if (TextUtils.isEmpty(myEmail)){
                    edtEmail.setError("Email can not empty");
                } else {
                    Toast.makeText(ElementEventActivity.this, myEmail, Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    btnSubmit.setEnabled(true);
                    btnOk.setEnabled(true);
                } else {
                    btnSubmit.setEnabled(false);
                    btnOk.setEnabled(false);
                }
            }
        });
    }
}
