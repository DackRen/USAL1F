package com.example.renjunzhou.smarthome.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.renjunzhou.smarthome.R;
import com.example.renjunzhou.smarthome.coordinator.messagecoordinator.IMessageCoordinator;
import com.example.renjunzhou.smarthome.coordinator.messagecoordinator.MessageCoordinator;

public class MessageActivity extends AppCompatActivity {
    private Button sendMessageButton;
    private EditText messageEditText;
    private EditText password;
    private IMessageCoordinator messageCoordinator = new MessageCoordinator(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        messageEditText = (EditText) findViewById(R.id.messageEditText);
        password = (EditText) findViewById(R.id.password);


        sendMessageButton = (Button) findViewById(R.id.sendMessageButton);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    messageCoordinator.sendMessage(password.getText().toString(),messageEditText.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    @Override
    protected void onStop(){
        super.onStop();
        messageCoordinator.connectService();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        messageCoordinator.connectService();
    }
}
