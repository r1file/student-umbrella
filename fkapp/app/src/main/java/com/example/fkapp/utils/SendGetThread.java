package com.example.fkapp.utils;

import java.io.IOException;

public class SendGetThread extends Thread implements Runnable{
    String result;
    String url;
    public SendGetThread(String url) throws IOException {
        this.url=url;
    }
    @Override
    public void run(){
        String str = RequestUtils.sendGet(url);
        result = str;
        System.out.println("这是得到的请求  " + str);
    }
    public String getResult() {
        return result;
    }
}
