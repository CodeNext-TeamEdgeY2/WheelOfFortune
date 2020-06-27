package com.example.wheeloffortune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
    }
    public void openMainActivity(View view) {
        Intent intent = new Intent(WinActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void openPlayActivity(View view) {
        Intent intent = new Intent(WinActivity.this, PlayActivity.class);
        startActivity(intent);
    }
}

