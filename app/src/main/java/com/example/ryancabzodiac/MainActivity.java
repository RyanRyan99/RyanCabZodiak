package com.example.ryancabzodiac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

Button btn_rml;
EditText et_nm, et_tgl_lhr;
String var_nm, var_tgl;
Calendar c;
DatePickerDialog dtp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nm= findViewById(R.id.et_nm);
        et_tgl_lhr = findViewById(R.id.et_tgl_lhr);
        btn_rml = findViewById(R.id.btn_rml);


        et_tgl_lhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dtp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        et_tgl_lhr.setText(mDay + "/" +(mMonth+1) + "/" + mYear);
                    }
                },day,month,year);
                dtp.show();
            }
        });


        btn_rml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_tgl_lhr.getText().toString().length() == 0){
                    et_tgl_lhr.setError("Tanggal Harus Diisi");
                }else {
                    var_nm = et_nm.getText().toString();
                    var_tgl = et_tgl_lhr.getText().toString();
                    Intent abc = new Intent(MainActivity.this,RamalanMu.class);
                    Bundle b = new Bundle();
                    b.putString("parse_tanggal", var_tgl);
                    b.putString("parse_nama", var_nm);
                    abc.putExtras(b);
                    startActivity(abc);
                }
            }
        });

        }
    }

