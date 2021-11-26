package com.example.fkapp.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fkapp.BtsReg;
import com.example.fkapp.EditTextActivity;
import com.example.fkapp.List1;
import com.example.fkapp.LsReg;
import com.example.fkapp.MainActivity;
import com.example.fkapp.MysqlTest;
import com.example.fkapp.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private Button mBtnEditText;
    private Button mBtList1;
    private Button mBtBts;
    private Button mBtLts;
    private Button mBtsql;
    private View contentView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        mBtnEditText=(Button) root.findViewById(R.id.btn_exittext);
        mBtnEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            //跳转到登陆界面
                Intent intent0=new Intent(getActivity(), EditTextActivity.class);
                startActivity(intent0);
            }
        });
        mBtList1=root.findViewById(R.id.btn_list1);
        mBtList1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //跳转到每日健康反馈表单填写界面
                Intent intent1=new Intent(getActivity(), List1.class);
                startActivity(intent1);
            }
        });
        mBtBts=root.findViewById(R.id.btn_BtsReg);
        mBtBts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //跳转到返校登记填写界面
                Intent intent2 = new Intent(getActivity(), BtsReg.class);
                startActivity(intent2);
            }
        });

        mBtLts =root.findViewById(R.id.btn_LsReg);
        mBtLts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //跳转到返校登记填写界面
                Intent intent3 = new Intent(getActivity(), LsReg.class);
                startActivity(intent3);
            }
        });
        mBtsql = (Button)root.findViewById(R.id.btn_mysql);
        mBtsql.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //跳转到返校登记填写界面
                Intent intent = new Intent(getActivity(), MysqlTest.class);
                startActivity(intent);
            }
        });

        return root;

    }
}