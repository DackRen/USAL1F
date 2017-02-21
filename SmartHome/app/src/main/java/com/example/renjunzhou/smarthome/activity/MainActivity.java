package com.example.renjunzhou.smarthome.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.renjunzhou.smarthome.R;
import com.example.renjunzhou.smarthome.coordinator.controlcoordinator.ControlCoordinator;
import com.example.renjunzhou.smarthome.coordinator.controlcoordinator.IControlCoordinator;

public class MainActivity extends AppCompatActivity {

//    private Button messageActivityButton;
//    private Button restart;

    IControlCoordinator controlCoordinator = new ControlCoordinator(this);

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.applianceActivityButton).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ControlActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.messageActivityButton).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.restart).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                controlCoordinator.connectService();
            }
        });

        findViewById(R.id.easyGetUp).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // controlCoordinator.connectService();
            }
        });
    }

}

