package com.example.fkapp;

public class AppNetConfig {
    //json配置网络请求
    public static final String JSONBASE_URL = "http://192.168.1.112:8080/";
    public static final String INDEX_URL = JSONBASE_URL + "json/index.json";

    //Mysql数据库网络配置
    public static final String FORNAME = "com.mysql.jdbc.Driver";
    public static final String MYSQLBASE_URL = "jdbc:mysql:/192.168.1.112:3306/fkapp?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai\"";

}
