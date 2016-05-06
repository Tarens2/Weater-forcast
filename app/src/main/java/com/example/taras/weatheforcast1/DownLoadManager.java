package com.example.taras.weatheforcast1;

/**
 * Created by Taras on 02.05.2016.
 */
public class DownLoadManager {
    String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String DAY5_WEATHER = "forecast?q=";
    String MODE = "&mode=json";
    String forAPPID = "&appid=";
    String APPID="79cce4c34a7b22bf66b5b112219272b0";

//http://api.openweathermap.org/data/2.5/forecast?q=london&mode=json&appid=d8a54da4ada01c1de42961246c36847a

    DB db;

    public DownLoadManager(DB dbh){
        db = dbh;
    }

    public void downloadJsonToDB(String cityName){
        
        new DownloadJson(db).execute(BASE_URL + DAY5_WEATHER + cityName + MODE + forAPPID + APPID);
    }
}
