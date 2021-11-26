package com.example.fkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private Button mBtnEditText;
    private Button mBtList1;
    private Button mBtBts;


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
        mBtBts= (Button) findViewById(R.id.btn_BtsReg);
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

}