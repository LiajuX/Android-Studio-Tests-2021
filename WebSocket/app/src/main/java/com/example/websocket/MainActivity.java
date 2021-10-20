package com.example.websocket;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

public class MainActivity extends AppCompatActivity {
    private MyWebSocketListener listener;
    private TextView chatText;
    private OkHttpClient client;
    private WebSocket ws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatText = findViewById(R.id.inputChat);
        client = new OkHttpClient();
    }

    public void startWebSocket() {
        Request req = new Request.Builder().url("wss://demo.piesocket.com/v3/channel_1?api_key=oCdCMcMPQpbvNjUIzqtvF1d2X2okWpDQj4AwARJuAgtjhzKxVEjQU6IdCjwm&notify_self").build();

        listener = new MyWebSocketListener(chatText, this);
        ws = client.newWebSocket(req, listener);

        client.dispatcher().executorService().shutdown();
    }

    public void start(View view) {
        startWebSocket();
    }

    public void sendMessage(View view) {
        TextView msg = findViewById(R.id.inputMessage);

        chatText.setMovementMethod(new ScrollingMovementMethod());
        chatText.setText(chatText.getText().toString() + "\n\nEnviei: " + msg.getText().toString());

        ws.send(msg.getText().toString());
    }

    @Override
    protected void onDestroy() {
        ws.close(1000, "Fechando...");
        super.onDestroy();
    }
}