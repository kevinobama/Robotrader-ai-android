package com.example.kevingates.robotrader_ai_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View View)
    {

        Intent login = new Intent(LoginActivity.this, RobotsActivity.class);
        startActivity(login);
    }
    //
    public void signUp(View View)
    {
        Intent login = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(login);
    }
}
