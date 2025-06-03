package com.example.chronoforge;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.chronoforge.models.Chats;
import com.example.chronoforge.models.User;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.settings);
        ImageView imageView = findViewById(R.id.user_pic);
        int radiusInDp = 30;
        float density = getResources().getDisplayMetrics().density;
        int radiusInPx = (int) (radiusInDp * density);

        Glide.with(this)
                .load("https://wallpaperaccess.com/full/11925634.jpg")
                .transform(new RoundedCorners(radiusInPx))
                .into(imageView);


    }
}
