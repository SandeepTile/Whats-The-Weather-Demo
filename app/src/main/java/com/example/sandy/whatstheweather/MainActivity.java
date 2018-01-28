package com.example.sandy.whatstheweather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText cityName;

    public void findWeather(View view)
    {
        Log.i("city Name",cityName.getText().toString());

     /*   DownloadTask task=new DownloadTask();

        try {
            task.execute("http://api.openweathermap.org/data/2.5/weather?q=" + cityName.getText().toString());

        }catch (Exception e)
        {

            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName=(EditText)findViewById(R.id.cityName);


    }

    public class DownloadTask extends AsyncTask<String,Void,String> {


        @Override
        protected String doInBackground(String... urls) {

            String results="";
            URL url;
            HttpURLConnection urlConnection=null;

            try {

                url=new URL(urls[0]);

                urlConnection=(HttpURLConnection)url.openConnection();

                InputStream in=urlConnection.getInputStream();

                InputStreamReader reader=new InputStreamReader(in);

                int data=reader.read();

                while (data !=-1){

                    char current=(char) data;

                    results +=current;

                    data=reader.read();
                }

                return results;

            }catch (Exception e){

                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            try {

                JSONObject jsonObject = new JSONObject(results);

                String weatherinfo = jsonObject.getString("weather");

                Log.i("weather Content", weatherinfo);

                JSONArray arr = new JSONArray(weatherinfo);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);

                    Log.i("Main", jsonPart.getString("main"));
                    Log.i("Description", jsonPart.getString("description"));
                }

            } catch (JSONException e) {

                e.printStackTrace();
            }

        }
    }
}
