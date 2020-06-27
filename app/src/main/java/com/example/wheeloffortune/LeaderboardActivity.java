package com.example.wheeloffortune;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {
    EditText editText;
    ListView leadLV;
    FirebaseDatabase database;
    DatabaseReference reference;
    String name;
    ArrayList<String> nameArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("leaderboard");
        editText = findViewById(R.id.edittextName);
        leadLV = findViewById(R.id.leaderboardLV);
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(LeaderboardActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void openPlayActivity(View view) {
        Intent intent = new Intent(LeaderboardActivity.this, PlayActivity.class);
        startActivity(intent);
    }

    public void addToLeaderBoard(View view) {
        name = editText.getText().toString();
        //nameArrayList.add(name);
        reference = database.getReference().child("leaderboard");
        reference.push().setValue(name);

    }

}
