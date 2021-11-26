package com.example.fkapp.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("本软件使用的是腾讯新闻的接口\n" +
                "数据最终来源是WHO和霍普金斯大学网站\n" +
                "作者：\n" +
                "联系方式：");
    }

    public LiveData<String> getText() {
        return mText;
    }
}