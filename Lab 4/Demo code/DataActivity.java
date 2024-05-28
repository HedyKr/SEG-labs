package com.example.lab4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    TextView selected_img_tv;
    EditText data_edittext;
    Button submit_btn;

    ImageView vader_img, obiwan_img, yoda_img;
    String drawableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        data_edittext = findViewById(R.id.data_edittext);
        submit_btn = findViewById(R.id.submit_button);
        vader_img = findViewById(R.id.vader_img);
        obiwan_img = findViewById(R.id.obiwan_img);
        yoda_img = findViewById(R.id.yoda_img);
        selected_img_tv = findViewById(R.id.selected_img_textview);

        drawableName = "vader";
        vader_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_img_tv.setText(R.string.vader);
                drawableName = "vader";
            }
        });

        obiwan_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_img_tv.setText(R.string.obiwan);
                drawableName = "obiwan";
            }
        });

        yoda_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_img_tv.setText(R.string.yoda);
                drawableName = "yoda";
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Data Activity");
        }

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = data_edittext.getText().toString();

                Intent returnIntent = getIntent();
                returnIntent.putExtra("message", message);
                returnIntent.putExtra("drawableName", drawableName);
                setResult(RESULT_OK, returnIntent);

                finish();
            }
        });
    }
}