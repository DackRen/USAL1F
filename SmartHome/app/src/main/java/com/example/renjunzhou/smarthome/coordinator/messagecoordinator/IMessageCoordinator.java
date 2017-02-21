package com.example.renjunzhou.smarthome.coordinator.messagecoordinator;

import android.text.Editable;

/**
 * Created by renjunzhou on 2016/12/27.
 */

public interface IMessageCoordinator {
    void sendMessage(String seed, String clearText) throws Exception;

    void connectService();
}
