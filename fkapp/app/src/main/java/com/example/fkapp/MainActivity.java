package com.example.fkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.mysql.jdbc.Statement;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private Button mBtsql;
    private TextView tv_show;
    private ImageView img_show;
    private TextView tv_sqlshow;
    private Button bt_show;

    //在主线程中更新UI
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case 0x12:
                    String s = (String) msg.obj;
                    tv_sqlshow.setText(s); //显示数据库中的数据
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
       /* mBtnEditText=(Button)findViewById(R.id.btn_exittext);
        Button mBtnEditText = (Button) findViewById(R.id.btn_exittext);
        mBtnEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            //跳转到登陆界面
                Intent intent=new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(intent);
            }
        });
        Button mBtList1 = (Button) findViewById(R.id.btn_list1);
        mBtList1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //跳转到每日健康反馈表单填写界面
                Intent intent=new Intent(MainActivity.this, List1.class);
                startActivity(intent);
            }
        });
        Button mBtBts = (Button) findViewById(R.id.btn_BtsReg);
        mBtBts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //跳转到返校登记填写界面
                Intent intent = new Intent(MainActivity.this,BtsReg.class);
                startActivity(intent);
            }
        });

        Button mBtLts = (Button) findViewById(R.id.btn_LsReg);
        mBtLts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //跳转到返校登记填写界面
                Intent intent = new Intent(MainActivity.this, LsReg.class);
                startActivity(intent);
            }
        });*/


        mBtsql = (Button) findViewById(R.id.btn_mysql);
        mBtsql.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //跳转到返校登记填写界面
                Intent intent = new Intent(MainActivity.this,MysqlTest.class);
                startActivity(intent);
            }
        });




    }

}