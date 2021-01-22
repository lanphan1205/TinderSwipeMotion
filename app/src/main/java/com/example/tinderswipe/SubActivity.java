package com.example.tinderswipe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class SubActivity extends AppCompatActivity {

    private ImageView imageViewProfileDetail;
    private TextView textViewNameAgeDetail;
    private TextView textViewLocationDetail;
    private FloatingActionButton floatingActionButtonBack;
    public static final String PROFILE_DETAIL = "PROFILE_DETAIL";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        imageViewProfileDetail = findViewById(R.id.imageViewDetail);
        textViewNameAgeDetail = findViewById(R.id.textViewNameAgeDetail);
        textViewLocationDetail = findViewById(R.id.textViewLocationDetail);

        Gson gson = new Gson();
        String stringProfileDetail = getIntent().getStringExtra(PROFILE_DETAIL);
        if(stringProfileDetail != null) {
            Type type = new TypeToken<Profile>(){}.getType();
            Profile mProfile = gson.fromJson(stringProfileDetail, type);
            Log.i("Profile Detail", stringProfileDetail);

            Glide.with(SubActivity.this).load(mProfile.getImageUrl()).into(imageViewProfileDetail);
            textViewNameAgeDetail.setText(mProfile.getName() + ", " + mProfile.getAge());
            textViewLocationDetail.setText(mProfile.getLocation());

        }

        floatingActionButtonBack = findViewById(R.id.floatingActionButtonBack);
        floatingActionButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
