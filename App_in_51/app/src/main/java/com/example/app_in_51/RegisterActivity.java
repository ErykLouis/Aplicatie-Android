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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {
    private Button register_button;
    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputEditText repeat_password;
    private TextInputEditText email;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        InitComponents();
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(ValidateFields())
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean ValidateFields()
    {
        //Validari Empty
        if(TextUtils.isEmpty(username.getText()))
        {
            Toast.makeText(getApplicationContext(),"You must fill your Username",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password.getText()))
        {
            Toast.makeText(getApplicationContext(),"You must fill your Password",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(repeat_password.getText()))
        {
            Toast.makeText(getApplicationContext(),"You must repeat your Password",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(email.getText()))
        {
            Toast.makeText(getApplicationContext(),"You must fill your Email",Toast.LENGTH_SHORT).show();
            return false;
        }

        //Validare match parole
        Editable pass = password.getText();
        Editable rep = repeat_password.getText();
        if(pass != rep)
        {
            Toast.makeText(getApplicationContext(),"Your Password should be the same",Toast.LENGTH_SHORT).show();
            return false;
        }

        //Validare mail
        if(!ValidateEmail(email.getText()))
        {
            Toast.makeText(getApplicationContext(),"Please enter a valid email adress",Toast.LENGTH_SHORT).show();
            return false;
        }

        //Validare Username
        if(username.getText().length() < 3)
        {
            Toast.makeText(getApplicationContext(),"Username must have at least 3 characters",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public static boolean ValidateEmail(Editable emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    //TO DO -> VALIDARE EMAIL IN BAZA DE DATE

    void InitComponents()
    {
        register_button = findViewById(R.id.register_button_register);
        username = findViewById(R.id.username_input_text);
        password = findViewById(R.id.password_input_text);
        repeat_password = findViewById(R.id.repeat_input_text);
        email = findViewById(R.id.email_input_text);
    }
}