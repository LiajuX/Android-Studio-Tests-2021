package com.example.starwarsmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchForMovie(View view) {
        String url = "https://swapi.dev/api/films/";

        EditText txtID = findViewById(R.id.inputID);
        url += txtID.getText().toString();

        TextView txtTitle = findViewById(R.id.textTitle);
        TextView txtDirector = findViewById(R.id.textDirector);
        TextView txtMessage = findViewById(R.id.textMessage);

        new DataGetter(txtTitle, txtDirector, txtMessage).execute(url);
    }
}