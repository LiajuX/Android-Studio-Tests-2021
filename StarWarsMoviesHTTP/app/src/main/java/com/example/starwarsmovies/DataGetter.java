package com.example.starwarsmovies;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String, Void, String> {
    private EditText txtTitle;
    private EditText txtDirector;
    private TextView txtMessage;

    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        String result = NetworkToolkit.doGet(url);

        return result;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        txtMessage.setText("Filme encontrado!");

        try {
            JSONObject jsonResponse = new JSONObject(s);

            String title = jsonResponse.getString("title");
            String director = jsonResponse.getString("director");

            txtTitle.setText(title);
            txtDirector.setText(director);

        } catch (JSONException e) {
            this.txtTitle.setText("---");
            this.txtDirector.setText("---");
            this.txtMessage.setText("Filme não encontrado!");
        }
    }

    public DataGetter(EditText txtTitle, EditText txtDirector, TextView txtMessage) {
        this.txtTitle = txtTitle;
        this.txtDirector = txtDirector;
        this.txtMessage = txtMessage;

        txtMessage.setText("Pesquisando...");
    }
}
