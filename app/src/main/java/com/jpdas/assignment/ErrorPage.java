package com.jpdas.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.jpdas.assignment.Utils.Extras;

public class ErrorPage extends AppCompatActivity {

    private TextView textErrorType, textErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_page);
        textErrorType = findViewById(R.id.text_view_error_type);
        textErrorMessage = findViewById(R.id.text_view_error_message);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String internet_con = (String) bundle.get(Extras.CHECK_INTERNET);
            String type = (String) bundle.get(Extras.SOMETHING_WENT_WRONG);
            String message = (String) bundle.get(Extras.ERROR_MESSAGE_TEXT);
            textErrorType.setText(type);
            textErrorMessage.setText(message);
            textErrorMessage.setText(internet_con);
        }

    }

}
