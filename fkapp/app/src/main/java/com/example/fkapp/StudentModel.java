package com.example.fkapp;

public class StudentModel {

    private int id;
    private int sid;
    private String sname;
    private String spwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

//    public StudentModel(int id, int sid, String sname, String spwd) {
//        this.id = id;
//        this.sid = sid;
//        this.sname = sname;
//        this.spwd = spwd;
//    }

//    @Override
//    public String toString() {
//        return "StudentModel{" +
//                "id=" + id +
//                ", sid=" + sid +
//                ", sname='" + sname + '\'' +
//                ", spwd='" + spwd + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return id + "," + sid + "," + sname + "," + spwd;
    }
}
