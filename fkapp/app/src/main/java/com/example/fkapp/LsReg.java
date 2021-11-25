package com.example.fkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class LsReg extends AppCompatActivity {
    private Button showdialog;
    private DatePickerDialog datePickerDialog;
    //private Button textdialog;

    //选择时间Dialog
    private TimePickerDialog timePickerDialog;

    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ls_reg);
        showdialog = (Button) findViewById(R.id.LsReg_et1);
        //textdialog = (Button) findViewById(R.id.);
        calendar = Calendar.getInstance();
        showdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
            private void showDialog() {
                datePickerDialog = new DatePickerDialog(
                        LsReg.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //monthOfYear 得到的月份会减1所以我们要加1
                        String time = String.valueOf(year) + "年" + String.valueOf(monthOfYear + 1) + "月" + Integer.toString(dayOfMonth)+"日";
                        showdialog.setText(time);
                        //Log.d("测试", time);
                    }
                },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                //自动弹出键盘问题解决
                datePickerDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            }
        });
    }
}