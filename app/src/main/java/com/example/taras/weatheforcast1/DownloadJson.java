package com.example.taras.weatheforcast1;

import android.os.AsyncTask;
import android.util.Log;

import com.example.taras.weatheforcast1.model.WetherObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Taras on 02.05.2016.
 */
public class DownloadJson extends AsyncTask<String, Void, JSONObject> {
    DB dbhelper;

    DownloadJson(DB dbh) {
        super();
        dbhelper = dbh;
    }

    @Override
    protected JSONObject doInBackground(String... params) {

        JSONObject json = null;
        String iUrl = params[0];
        HttpURLConnection conn = null;
        InputStreamReader in = null;
        String str = " ";
        try {
            conn = (HttpURLConnection) new URL(iUrl).openConnection();
            conn.setDoInput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setReadTimeout(10000);
            conn.connect();
            StringBuilder sb = new StringBuilder();
            in = new InputStreamReader(conn.getInputStream(), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(in);
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }
            bufferedReader.close();
            str = sb.toString();
            json = new JSONObject(str);

        } catch (MalformedURLException ex) {
            Log.v("downloadJson", ex.toString());
        } catch (IOException ex) {
            Log.v("downloadJson", ex.toString());
        } catch (OutOfMemoryError e) {
            Log.v("downloadJson", e.toString());
        } catch (JSONException e) {
            Log.v("downloadJson", e.toString());
        } catch (Exception e) {
            Log.v("downloadJson", e.toString());
        } finally {
            if (conn != null)
                conn.disconnect();
        }
        return json;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);
        int i = 0;
        WetherObject weObj;
        Log.v(MainActivity.tag, ""+result);
        try {
            JSONArray jlist = result.getJSONArray("list");
            JSONArray jweather;
            JSONObject jmain;
            JSONObject jweather0;
            while (true) {

                JSONObject list0 = jlist.getJSONObject(i);
                jweather = list0.getJSONArray("weather");
                jmain = list0.getJSONObject("main");
                jweather0 = jweather.getJSONObject(0);

                weObj = new WetherObject();
                weObj.setTime(list0.getString("dt_txt"));
                weObj.setTempInString(jmain.getString("temp"));
                weObj.setDescription(jweather0.getString("description"));
                weObj.setImg(jweather0.getString("icon"));


                Log.v("weObj", weObj.getDescription()+' '+weObj.getTemp()+" "+weObj.getTime()+" "+weObj.getImg());
                dbhelper.addRec(weObj);
                i++;
            }
        } catch (JSONException e) {
            Log.v("downloadJson", e.toString());
        } catch (Exception e) {

            Log.v("downloadJson", e.toString());
        }

    }

}
