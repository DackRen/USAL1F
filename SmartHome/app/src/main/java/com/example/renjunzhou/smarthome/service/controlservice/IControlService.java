package com.example.renjunzhou.smarthome.service.controlservice;

/**
 * Created by renjunzhou on 2016/12/27.
 */

public interface IControlService {
    void turnOn();
    void turnOff();

    void changeLevel(String p);
    void changeMood(String s);
}
