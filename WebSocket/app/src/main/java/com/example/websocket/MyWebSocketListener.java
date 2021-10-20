package com.example.websocket;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

public final class MyWebSocketListener extends okhttp3.WebSocketListener {
    private TextView output;
    private AppCompatActivity activity;

    public MyWebSocketListener(TextView output, AppCompatActivity act) {
        this.output = output;
        this.activity = act;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.send("Iniciando WebSocket...");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        updateTextView(text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        updateTextView(bytes.hex());
    }

    @Override
    public void onClosing(WebSocket websocket, int code, String reason) {
        websocket.close(1000, null);
        updateTextView("Encerrado: " + code + " / " + reason);
    }

    @Override
    public void onFailure(WebSocket websocket, Throwable t, Response response) {
        updateTextView("Erro: " + t.getMessage());
    }

    public void updateTextView(final String text) {
        this.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                output.setMovementMethod(new ScrollingMovementMethod());

                if (output.getText().toString().isEmpty()) {
                    output.setText(output.getText().toString() + "Recebi: " + text);

                } else {
                    output.setText(output.getText().toString() + "\n\nRecebi: " + text);
                }
            }
        });
    }
}
