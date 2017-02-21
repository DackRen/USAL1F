package com.example.renjunzhou.smarthome.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.renjunzhou.smarthome.R;
import com.example.renjunzhou.smarthome.coordinator.controlcoordinator.ControlCoordinator;
import com.example.renjunzhou.smarthome.coordinator.controlcoordinator.IControlCoordinator;

import java.util.Random;

public class ControlActivity extends AppCompatActivity {

    private IControlCoordinator controlCoordinator = new ControlCoordinator(this);
    private Button turnOnButton;
    private Button turnOffButton;
    private SeekBar level;
    private Button moodButton;
    int y=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        turnOnButton = (Button) findViewById(R.id.turnOnButton);
        turnOnButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                controlCoordinator.TurnOn();
            }
        });

        turnOffButton = (Button) findViewById(R.id.turnOffButton);
        turnOffButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                controlCoordinator.TurnOff();
            }
        });

        level = (SeekBar) findViewById(R.id.seekBar);
        level.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("Seekbar","onStopTrackingTouch ");
                int progress = seekBar.getProgress();
                String p = String.valueOf(progress);
                controlCoordinator.changeLevel(p);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("Seekbar","onStartTrackingTouch ");
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Seekbar", "onProgressChanged " + progress);
            }
        });


        moodButton = (Button) findViewById(R.id.moodButton);
        moodButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (y==5)
                    y=1;
                //TODO:add normal code.......
                int max=4;
                int min=1;
                Random random = new Random();
                int s = random.nextInt(max)%(max-min+1) + min;



                controlCoordinator.changeMood(""+y++);
            }
        });
        controlCoordinator.connectService();
    }
    @Override
    protected void onStop(){
        super.onStop();
        controlCoordinator.connectService();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        controlCoordinator.connectService();
    }
}
