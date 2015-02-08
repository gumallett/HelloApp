package com.helloapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Random;

public class MyActivity extends Activity {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz ";
    private boolean random = false;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText messageText = (EditText) findViewById(R.id.message);
        String message;

        if(random) {
            message = randomString(12);
        }
        else {
            message = messageText.getText().toString();
        }

        intent.putExtra("MESSAGE", message);
        startActivity(intent);

    }

    public void toggleRandom(View view) {
        CheckBox randomCheckBox = (CheckBox) findViewById(R.id.random);
        random = randomCheckBox.isChecked();

        EditText messageText = (EditText) findViewById(R.id.message);
        messageText.setEnabled(!random);
        messageText.setText("");
    }

    private String randomString(int length) {
        Random r = new Random();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < length; i++) {
            int idx = r.nextInt(27);
            builder.append(alphabet.charAt(idx));
        }

        return builder.toString();
    }
}
