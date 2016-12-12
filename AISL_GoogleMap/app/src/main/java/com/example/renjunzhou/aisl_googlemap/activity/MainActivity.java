package com.example.renjunzhou.aisl_googlemap.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.renjunzhou.aisl_googlemap.R;

public class MainActivity extends AppCompatActivity {
//    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        //regiest listener
        button.setOnClickListener(lAuditeurDuBouton);
    }

    private View.OnClickListener lAuditeurDuBouton = new View.OnClickListener() {
        public void onClick(View v) {
            Intent i =new Intent(MainActivity.this,MapsActivity.class);
            startActivity(i);
        }};
}
