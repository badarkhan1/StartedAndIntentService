package com.example.servicesrevisited;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    MyService myService;
    MyIntentService myIntentService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnstart);
        button.setOnClickListener(this);
        myService = new MyService();
        myIntentService = new MyIntentService();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnstart:
                startService(new Intent(this,MyIntentService.class));
                break;
            default:
                break;
        }
    }
}






















