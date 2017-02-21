package com.example.renjunzhou.smarthome.utils;

/**
 * Created by renjunzhou on 2016/12/27.
 */

public abstract class AbstractAccess {
    public abstract void sendMessage(String s);

    public abstract void start();

    public abstract void connectDevice(String s);

    public abstract String receiveMessage();
}
