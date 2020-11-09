package com.example.app_in_51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private Button login_button;
    private Button register_button;
    private TextInputEditText username;
    private TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitComponents();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidateFields()) {
                    Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                    startActivity(intent);
                }
            }
        });
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean ValidateFields()
    {
        if(TextUtils.isEmpty(username.getText()))
        {
            Toast.makeText(getApplicationContext(),"You must fill your Username",Toast.LENGTH_SHORT).show();
            return  false;
        }
        if(TextUtils.isEmpty(password.getText()))
        {
            Toast.makeText(getApplicationContext(),"You must fill your Password",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    void InitComponents()
    {
        login_button = (Button) findViewById(R.id.login_button);
        register_button = (Button) findViewById(R.id.register_button);
        username =  (TextInputEditText) findViewById(R.id.username_text_input);
        password = (TextInputEditText) findViewById(R.id.password_text_input);
    }
}