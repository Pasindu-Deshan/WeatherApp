package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;


public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{
    private Context context;
    View v;

    public MarkerInfoWindowAdapter(Context context){
        this.context = context.getApplicationContext();
    }
    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        return v;
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_info_window_adapter,null);
        TextView txtWeather = (TextView) v.findViewById(R.id.txtWeather);
        TextView txt_details = (TextView) v.findViewById(R.id.txt_details);

        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.wheather);

        txtWeather.setText(marker.getTitle());
        txt_details.setText(marker.getSnippet());
        return v;
    }
}
