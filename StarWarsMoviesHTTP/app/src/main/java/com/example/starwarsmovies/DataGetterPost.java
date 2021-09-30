package com.example.starwarsmovies;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetterPost extends AsyncTask<String, Void, String> {
    private TextView txtMessage;

    @Override
    protected  String doInBackground(String... strings) {
        return NetworkToolkit.doPost(strings[0], strings[1]);
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonResponse = new JSONObject(s);

            txtMessage.setText(jsonResponse.toString());

        } catch (JSONException e) {
            this.txtMessage.setText(e.getMessage());
        }
    }

    public DataGetterPost(TextView txtMessage) {
        this.txtMessage = txtMessage;
    }
}
