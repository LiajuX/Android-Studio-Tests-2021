package com.example.starwarsmovies;

import android.os.AsyncTask;
import android.widget.TextView;

public class DataGetterDelete extends AsyncTask<String, Void, Boolean> {
    TextView txtMessage;

    @Override
    protected Boolean doInBackground(String... strings) {
        return NetworkToolkit.doDelete(strings[0]);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean) {
            txtMessage.setText("Filme deletado!");

        } else {
            txtMessage.setText("Não foi possível deletar...");
        }
    }

    public DataGetterDelete(TextView txtMessage) {
        this.txtMessage = txtMessage;
    }
}
