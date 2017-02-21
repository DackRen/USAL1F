package com.example.renjunzhou.smarthome.coordinator.messagecoordinator;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.renjunzhou.smarthome.service.messageservice.MessageService;
import com.example.renjunzhou.smarthome.utils.AbstractAccess;
import com.example.renjunzhou.smarthome.utils.Bluetooth;

/**
 * Created by renjunzhou on 2016/12/27.
 *
 */

public class MessageCoordinator implements IMessageCoordinator {

    private final String TAG = "MessageCoordinator";

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Bluetooth.MESSAGE_STATE_CHANGE:
                    Log.d(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
                    break;
                case Bluetooth.MESSAGE_WRITE:
                    Log.d(TAG, "MESSAGE_WRITE ");
                    break;
                case Bluetooth.MESSAGE_READ:
                    Log.d(TAG, "MESSAGE_READ ");
                    break;
                case Bluetooth.MESSAGE_DEVICE_NAME:
                    Log.d(TAG, "MESSAGE_DEVICE_NAME "+msg);
                    break;
                case Bluetooth.MESSAGE_TOAST:
                    Log.d(TAG, "MESSAGE_TOAST "+msg);
                    break;
            }
        }
    };

    private Context _context;
    private AbstractAccess bt = new Bluetooth(_context, mHandler);

    public MessageCoordinator (Context context){
        this._context = context;
    }

    private MessageService messageService = new MessageService(bt);
    public void sendMessage(String seed, String clearText) throws Exception {
        messageService.sendMessage(seed,clearText);
    }
    public String receiveMessage(String seed) throws Exception {
        //TODO:Store your message in some database or serialization them.
        return messageService.receiveMessage(seed);
    }

    public void connectService(){
        try {
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter.isEnabled()) {
                bt.start();
                bt.connectDevice("HC-06");
                Log.d(TAG, "Btservice started - listening");
            } else {
                Log.w(TAG, "Btservice started - bluetooth is not enabled");
                //TODO: add expection system
            }
        } catch(Exception e){
            Log.e(TAG, "Unable to start bt ",e);
        }
    }
}
