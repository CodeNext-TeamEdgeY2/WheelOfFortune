package com.example.wheeloffortune;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    Spinner spinner01;
    String mysteryPhrase;
    String phraseBlanks;
    TextView phraseBox;
    EditText editTextLetter;
    ArrayList<String> lettersUsed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        spinner01 = findViewById(R.id.spinner01);
        phraseBox = findViewById(R.id.phaseBox);
        editTextLetter = findViewById(R.id.editTextLetter);
        String[] spinnerArray = {"Foods", "Places", "Fun and Games", "Song Lyrics"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, spinnerArray);
        spinner01.setAdapter(spinnerAdapter);
        lettersUsed = new ArrayList<>();
    }

    public void initiatePlay(View view){
        String retrieve = spinner01.getSelectedItem().toString();
        if (retrieve == "Foods"){
            mysteryPhrase = "breakfast burrito";
            phraseBlanks = "▯r▯▯▯▯▯s▯ ▯u▯▯▯▯▯";
        }
        else if (retrieve == "places"){
            mysteryPhrase = "Mountain View";
            phraseBlanks = "M▯▯▯▯▯▯▯ ▯i▯▯";
        }
        else if ( retrieve == "Fun and Games"){
            mysteryPhrase = "zip zap zop";
            phraseBlanks = "▯i▯ Z▯▯ ▯▯▯";
        }
        else {
            mysteryPhrase = "i just have a gut feeling";
            phraseBlanks = "▯ ▯u▯▯ ▯▯▯e ▯ G▯▯ ▯ee▯▯▯▯";
        }
        phraseBox.setText(phraseBlanks);
    }

    public void submissionChecker(View view) {
        String retrieve2 = editTextLetter.getText().toString().toLowerCase();
        if (mysteryPhrase.contains(retrieve2)){
            Toast myToast = Toast.makeText(this, "Your Letter Was Found!:)" , Toast.LENGTH_SHORT);
            myToast.show();
            myToast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);

        }
        else {
            Toast myToast = Toast.makeText(this, "Your Letter Was Not Found!:(", Toast.LENGTH_SHORT);
            myToast.show();
            myToast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        }
        lettersUsed.add(retrieve2);
    }
}
