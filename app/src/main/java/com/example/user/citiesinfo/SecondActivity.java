package com.example.user.citiesinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initViews();
        setPosition();
    }
    private  void initViews(){
        textPosition = findViewById(R.id.textPosition);
    }

    private void setPosition() {
        int position = getIntent().getIntExtra("KEY",0);
        String pos = String.valueOf(position);
        textPosition.setText(pos);

    }
}
