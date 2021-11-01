package com.example.fkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private Button mBtnEditText;
    private Button mBtList1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnEditText=(Button)findViewById(R.id.btn_exittext);
        mBtnEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            //跳转到登陆界面
                Intent intent=new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(intent);
            }
        });
        mBtList1=(Button)findViewById(R.id.btn_list1);
        mBtList1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //跳转到每日健康反馈表单填写界面
                Intent intent=new Intent(MainActivity.this, List1.class);
                startActivity(intent);
            }
        });




    }
}