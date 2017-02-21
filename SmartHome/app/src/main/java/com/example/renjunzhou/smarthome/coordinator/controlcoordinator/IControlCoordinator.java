package com.example.renjunzhou.smarthome.coordinator.controlcoordinator;

/**
 * Created by renjunzhou on 2016/12/27.
 */

public interface IControlCoordinator {
    void TurnOn();
    void TurnOff();

    void connectService();

    void changeLevel(String p);

    void changeMood(String s);
}
