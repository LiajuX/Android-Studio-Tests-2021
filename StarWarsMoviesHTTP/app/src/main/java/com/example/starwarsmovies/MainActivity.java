package com.example.starwarsmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // GET
    public void searchForMovie(View view) {
        String url = "https://swapi.dev/api/films/";

        EditText txtID = findViewById(R.id.inputID);
        url += txtID.getText().toString();

        EditText txtTitle = findViewById(R.id.inputTitle);
        EditText txtDirector = findViewById(R.id.inputDirector);
        TextView txtMessage = findViewById(R.id.textMessage);

        new DataGetter(txtTitle, txtDirector, txtMessage).execute(url);
    }

    // POST
    public void createNewMovie(View view) {
        String url = "https://swapi.dev/api/films/";

        String parameter = "{\n" +
                "   \"title\": \"testando\",\n" +
                "   \"director\": \"testando\"\n" +
                "}";

        TextView txtMessage = findViewById(R.id.textMessage);

        new DataGetterPost(txtMessage).execute(url, parameter);
    }

    // PUT
    public void updateMovie(View view) {
        try {
            String url = "https://swapi.dev/api/films/";

            EditText txtID = findViewById(R.id.inputID);
            url += txtID.getText().toString();

            EditText txtTitle = findViewById(R.id.inputTitle);
            EditText txtDirector = findViewById(R.id.inputDirector);
            TextView txtMessage = findViewById(R.id.textMessage);

            JSONObject messagePut = new JSONObject();
            messagePut.put("title", txtTitle.getText().toString());
            messagePut.put("director", txtDirector.getText().toString());

            new DataGetterPut(txtMessage).execute(url, messagePut.toString());

        } catch (JSONException e) {
            TextView txtMessage = findViewById(R.id.textMessage);
            txtMessage.setText("Erro ao realizar o PUT");
        }
    }

    // DELETE
    public void deleteMovie(View view) {
        String response;

        String url = "https://swapi.dev/api/films/";

        EditText txtID = findViewById(R.id.inputID);
        url += txtID.getText().toString();

        TextView txtMessage = findViewById(R.id.textMessage);

        new DataGetterDelete(txtMessage).execute(url);
    }
}