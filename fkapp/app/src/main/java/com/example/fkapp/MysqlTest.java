package com.example.fkapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * 笔记：用JDBC连接数据库的时候一定要在子线程中进行，然后再发送到主线程中操作
 * 不然会报错，所以new一个Thread再Runnable再用handler发送和接受消息
 */

public class MysqlTest extends AppCompatActivity {
    private TextView tv_show;
    private EditText editText;

    //在主线程中更新UI以及其他主线程操作
    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 0x12:
                    Toast.makeText(MysqlTest.this, "删除成功", Toast.LENGTH_LONG).show();
                    break;
                case 0x13:
                    Toast.makeText(MysqlTest.this, "删除失败", Toast.LENGTH_LONG).show();
                    break;
                case 0x14:
                    Toast.makeText(MysqlTest.this, "修改成功", Toast.LENGTH_LONG).show();
                    break;
                case 0x15:
                    Toast.makeText(MysqlTest.this, "修改失败", Toast.LENGTH_LONG).show();
                    break;
                case 0x16:
                    Toast.makeText(MysqlTest.this, "添加成功", Toast.LENGTH_LONG).show();
                    break;
                case 0x17:
                    Toast.makeText(MysqlTest.this, "添加失败", Toast.LENGTH_LONG).show();
                    break;
                case 0x18:
                    String s = (String) msg.obj;
                    tv_show.setText(s); //显示数据库中的数据
                    Toast.makeText(MysqlTest.this, "查询成功", Toast.LENGTH_LONG).show();
                    break;
                case 0x19:
                    tv_show.setText((String)msg.obj);
                    Toast.makeText(MysqlTest.this, "查询失败", Toast.LENGTH_LONG).show();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mysql);
        Button btn_insert = findViewById(R.id.btn_insert);
        Button btn_select = findViewById(R.id.btn_select);
        Button btn_update = findViewById(R.id.btn_update);
        Button btn_delete = findViewById(R.id.btn_delete);
        tv_show = findViewById(R.id.tv_datashow);
        editText = findViewById(R.id.tv_shuru);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = handler.obtainMessage();//建立消息通讯机制
                        //从EditText中获取数据，然后进行删除操作
                        String text = editText.getText().toString();
                        try {
                            int tv = Integer.parseInt(text.replaceAll("\\s", ""));//强制转换为int类型
                            if (StudentDAL.insert(tv, "上海海事大学", "201842010242")) {
                                message.what = 0x16; //添加成功标记
                            } else {
                                message.what = 0x17;//添加失败标记
                            }
                            handler.sendMessage(message);// 发消息通知主线程进行操作
                        }catch(Exception e){

                        }


                    }
                }).start();
            }
        });

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = handler.obtainMessage();//建立消息通讯机制
                        //从EditText中获取数据，然后进行删除操作
                        String text = editText.getText().toString();
                        try {
                            int tv = Integer.parseInt(text.replaceAll("\\s", ""));//强制转换为int类型
                            List<StudentModel> mp = StudentDAL.SelectById(tv); //用list来操作
                            if (mp != null) {
                                String ss = "";
                                for (int i = 0; i < mp.size(); i++) {//遍历数组
                                    ss += mp.get(i).toString(); //获得数据
                                    message.what = 0x18; //查询成功标记
                                    message.obj = ss; //把查询出来的数据赋值再obj上
                                }
                            } else {
                                message.what = 0x19;//查询失败标记
                                message.obj = "";
                            }
                            handler.sendMessage(message);// 发消息通知主线程进行操作
                        }catch(Exception e){
                        }
                    }
                }
                ).start();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //注意数据库操作只能在子线程操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = handler.obtainMessage();//建立消息通讯机制
                        //从EditText中获取数据，然后进行删除操作
                        String text = editText.getText().toString();
                        try{
                            int tv = Integer.parseInt(text.replaceAll("\\s", ""));//强制转换为int类型
                            if (StudentDAL.update(tv, "smu信工学院")) {
                                message.what = 0x14; //更新（修改）成功标记
                            } else {
                                message.what = 0x15;//更新（修改）失败标记
                            }
                            handler.sendMessage(message);// 发消息通知主线程进行操作
                        }catch(Exception e){

                        }

                    }
                }).start();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = handler.obtainMessage();//建立消息通讯机制
                        //从EditText中获取数据，然后进行删除操作
                        String text = editText.getText().toString();
                        try {
                            int tv = Integer.parseInt(text.replaceAll("\\s", ""));//强制转换为int类型
                            StudentDAL studentDAL = new StudentDAL();
                            if (studentDAL.delete(tv)) {
                                message.what = 0x12;//删除成功标记
                            } else {
                                message.what = 0x13;//删除失败标记
                            }
                            handler.sendMessage(message); // 发消息通知主线程进行操作
                        }catch(Exception e){

                        }
                    }
                }).start();
            }
        });
    }
}
