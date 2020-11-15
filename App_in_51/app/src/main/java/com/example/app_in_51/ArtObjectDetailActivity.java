package com.example.app_in_51;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtObjectDetailActivity extends AppCompatActivity {

    private String ART_OBJECT_KEY;
    private ImageView imageView;
    private ArtObjectAd artObjectAd;
    private TextView titleView;
    private TextView descriptionView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_object_detail);
        this.ART_OBJECT_KEY=getApplicationContext().getResources().getString(R.string.art_object_ad_key);
        this.artObjectAd = (ArtObjectAd) getIntent().getSerializableExtra(this.ART_OBJECT_KEY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.imageView=findViewById(R.id.adDetailImage);
        this.titleView=findViewById(R.id.adDetailTitle);
        this.descriptionView=findViewById(R.id.adDetailDescription);
        int imageId=getResources().getIdentifier(artObjectAd.getImageName(),"drawable",getPackageName());
        this.imageView.setImageResource(imageId);
        this.titleView.setText(this.artObjectAd.getTitle());
        this.descriptionView.setText(this.artObjectAd.getDescription());
    }
}