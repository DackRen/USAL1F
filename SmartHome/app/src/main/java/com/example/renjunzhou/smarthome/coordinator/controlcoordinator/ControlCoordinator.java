package com.example.renjunzhou.smarthome.coordinator.controlcoordinator;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.renjunzhou.smarthome.service.controlservice.ControlServiceFactory;
import com.example.renjunzhou.smarthome.service.controlservice.IControlService;
import com.example.renjunzhou.smarthome.utils.AbstractAccess;
import com.example.renjunzhou.smarthome.utils.Bluetooth;

/**
 * Created by renjunzhou on 2016/12/27.
 *
 */

public class ControlCoordinator implements IControlCoordinator {

    private final String TAG = "ControlCoordinator";

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

    public ControlCoordinator (Context context){
        this._context = context;
    }

    //private ControlServiceFactory controlServiceFactory = new ControlServiceFactory();

    private IControlService controlService = new ControlServiceFactory().createControlService(bt);


    public void TurnOn(){
        controlService.turnOn();
    }

    public void TurnOff(){
        controlService.turnOff();
    }

    public void changeLevel(String p) {
        //TODO:add this to controlService
        controlService.changeLevel(p);
    }

    @Override
    public void changeMood(String s) {
        controlService.changeMood(s);
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
