package com.example.renjunzhou.smarthome.service.controlservice;

import com.example.renjunzhou.smarthome.entity.Command;
import com.example.renjunzhou.smarthome.utils.AbstractAccess;

/**
 * Created by renjunzhou on 2016/12/27.
 *
 */

public class LightControlService implements IControlService {

    //TODO: Design different Transport Class and make change in there.
    private AbstractAccess _access;

    public LightControlService(AbstractAccess access) {
        this._access = access;
    }

    public void turnOn(){
        _access.sendMessage(Command.TURN_ON.getCommand());
    }

    public void turnOff(){
        _access.sendMessage(Command.TURN_OFF.getCommand());
    }

    @Override
    public void changeLevel(String p) {
        //change as p
        _access.sendMessage("<"+Command.CHANGE_LEVEL_FREE.getCommand()+p+">");

//        //fix level
//        switch (p){
//            case "0":
//                _access.sendMessage(Command.TURN_OFF.getCommand());
//                break;
//            case "1":
//                _access.sendMessage(Command.CHANGE_LEVEL_1.getCommand());
//                break;
//            case "2":
//                _access.sendMessage(Command.CHANGE_LEVEL_2.getCommand());
//                break;
//            case "3":
//                _access.sendMessage(Command.CHANGE_LEVEL_3.getCommand());
//                break;
//        }
    }

    @Override
    public void changeMood(String s) {
        switch (s) {
            case "1":
                _access.sendMessage(Command.CHANGE_MOOD_1.getCommand());
                break;
            case "2":
                _access.sendMessage(Command.CHANGE_MOOD_2.getCommand());
                break;
            case "3":
                _access.sendMessage(Command.CHANGE_MOOD_3.getCommand());
                break;
            case "4":
                _access.sendMessage(Command.CHANGE_MOOD_4.getCommand());
                break;
        }

    }
}
