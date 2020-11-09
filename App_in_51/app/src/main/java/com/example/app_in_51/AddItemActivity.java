package com.example.app_in_51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddItemActivity extends AppCompatActivity {
    private Button add_item_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        InitComponents();

        add_item_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateFields();
                AddToDataBase();
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                startActivity(intent);
            }
        });
    }
    void ValidateFields() {

    }

    void AddToDataBase(){

    }

    void InitComponents() {
        add_item_btn = findViewById(R.id.add_item_button);
    }
}