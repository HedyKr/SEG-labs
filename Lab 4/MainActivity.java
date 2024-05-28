package com.example.lab4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button selector_btn;
    TextView data_textview;
    ImageView profile_img;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selector_btn = findViewById(R.id.selector_btn);
        data_textview = findViewById(R.id.main_textview);
        profile_img = findViewById(R.id.imageView);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Main Activity");
        }

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        if ((result.getResultCode() == RESULT_OK) & (data != null)){
                            String message = data.getStringExtra("message");
                            String drawableName = data.getStringExtra("drawableName");

                            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
                            profile_img.setImageResource(resID);
                            data_textview.setText(message);
                        }
                    }
                }
        );

        selector_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DataActivity.class);
                launcher.launch(intent);
            }
        });

    }
}