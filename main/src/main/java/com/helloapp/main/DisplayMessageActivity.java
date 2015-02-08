package com.helloapp.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaymessageactivity);

        TextView messageText = (TextView) findViewById(R.id.message_messageText);
        messageText.setText(getIntent().getStringExtra("MESSAGE"));
    }
}