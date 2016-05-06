package com.example.taras.weatheforcast1.model;

import com.example.taras.weatheforcast1.R;

/**
 * Created by Taras on 04.05.2016.
 */
public class WetherObject {
    private String temp;
    private String description;
    private int img;
    private String time;


    public WetherObject(){
        temp = "0";
        description = "no description";
        img = R.mipmap.ic_launcher;
        time = "no time";
    }
    public WetherObject(String temp_, String description_, int img_, String time_){
        temp = temp_;
        description = description_;
        img = img_;
        time = time_;
    }

    public void setImg(String img) {
        switch (img) {
            case "01d":
                this.img = R.mipmap.ic_01d;
                break;
            case "01n":
                this.img = R.mipmap.ic_01n;
                break;
            case "02d":
                this.img = R.mipmap.ic_02d;
                break;
            case "02n":
                this.img = R.mipmap.ic_02n;
                break;
            case "03d":
                this.img = R.mipmap.ic_03d;
                break;
            case "03n":
                this.img = R.mipmap.ic_03n;
                break;
            case "04d":
                this.img = R.mipmap.ic_04d;
                break;
            case "04n":
                this.img = R.mipmap.ic_04n;
                break;
            case "09d":
                this.img = R.mipmap.ic_09d;
                break;
            case "09n":
                this.img = R.mipmap.ic_09n;
                break;
            case "10d":
                this.img = R.mipmap.ic_10d;
                break;
            case "10n":
                this.img = R.mipmap.ic_10n;
                break;
            case "11d":
                this.img = R.mipmap.ic_11d;
                break;
            case "11n":
                this.img = R.mipmap.ic_11n;
                break;
            case "13d":
                this.img = R.mipmap.ic_13d;
                break;
            case "13n":
                this.img = R.mipmap.ic_13n;
                break;
            case "50d":
                this.img = R.mipmap.ic_50d;
                break;
            case "50n":
                this.img = R.mipmap.ic_50n;
                break;
            default:
                this.img = R.mipmap.ic_launcher;
                break;
        }
    }

    public int getImg() {
        return img;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
    public void setTempInString(String temp) {
        double t1=Double.parseDouble(temp);
        int t2=(int)t1-273;
        String t=t2+"";
        if(t2>0) t = "+"+ t2;

        this.temp = t;
    }

    public String getTemp() {
        return temp;
    }
}
