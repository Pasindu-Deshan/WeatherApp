package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class FullReport extends AppCompatActivity {
    TextView area;
    Button btn_back;
    TextView txt_temp, txt_description;
    TextView txt_feel_like, txt_max, txt_min, txt_humidity, txt_pressure, txt_wind, txt_wind_degree, txt_sunset, txt_sunrise, txt_cloud;
    String geoLocation;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_report);

        Intent intent = getIntent();                                    //Get weather details
        String location = intent.getStringExtra("location");
        String country = intent.getStringExtra("country");
        String temp = intent.getStringExtra("temp");
        String feel_like = intent.getStringExtra("feel");
        int humidity = intent.getIntExtra("humidity",0);
        String description = intent.getStringExtra("description");
        String wind = intent.getStringExtra("wind");
        String cloud = intent.getStringExtra("cloud");
        float pressure = intent.getFloatExtra("pressure", 0);
        String deg = intent.getStringExtra("deg");
        String temp_min = intent.getStringExtra("temp_min");
        String temp_max = intent.getStringExtra("temp_max");
        String sunriseTime = intent.getStringExtra("sunriseTime");
        String sunsetTime = intent.getStringExtra("sunsetTime");
        geoLocation = intent.getStringExtra("geoLocation");

        area = findViewById(R.id.location);
        area.setText(geoLocation + "\n" + location + " " + country);

        txt_temp = findViewById(R.id.txt_temp);
        txt_temp.setText(temp + " °C");
        txt_description = findViewById(R.id.txt_description);
        txt_description.setText(description);

        txt_feel_like = findViewById(R.id.txt_feel_like);
        txt_max = findViewById(R.id.txt_max);
        txt_min = findViewById(R.id.txt_min);
        txt_humidity = findViewById(R.id.txt_humidity);
        txt_sunrise = findViewById(R.id.txt_sunrise);
        txt_sunset = findViewById(R.id.txt_sunset);
        txt_wind = findViewById(R.id.txt_wind);
        txt_wind_degree = findViewById(R.id.txt_wind_degree);
        txt_pressure = findViewById(R.id.txt_pressure);
        txt_cloud = findViewById(R.id.txt_cloud);

        txt_feel_like.setText(feel_like + " °C");
        txt_max.setText(temp_max + " °C");
        txt_min.setText(temp_min + " °C");
        txt_humidity.setText(humidity + "%");
        txt_wind.setText(wind + "m/s");
        txt_wind_degree.setText(deg + " °");
        txt_cloud.setText(cloud + "%");
        txt_sunrise.setText(sunriseTime);
        txt_sunset.setText(sunsetTime);
        txt_pressure.setText(pressure + " hPa");

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(back);
            }
        });
    }
}
