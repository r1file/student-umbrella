package com.example.fkapp.pojo;



import org.jetbrains.annotations.NotNull;

public class ContinentInfo {
    private String continent;
    private int confirmAdd;
    private int confirm;
    private int heal;
    private int dead;
    private int countryCount;
    private boolean isShow;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public ContinentInfo() {
        this.isShow=false;
    }

    public int getCountryCount() {return countryCount; }

    public void setCountryCount(int countryCount) {
        this.countryCount = countryCount;
    }

    @NotNull
    @Override
    public String toString() {
        return "ContinentInfo{" +
                "continent='" + continent + '\'' +
                ", confirmAdd=" + confirmAdd +
                ", confirm=" + confirm +
                ", heal=" + heal +
                ", dead=" + dead +
                '}';
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getConfirmAdd() {
        return confirmAdd;
    }

    public void setConfirmAdd(int confirmAdd) {
        this.confirmAdd = confirmAdd;
    }

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }
}