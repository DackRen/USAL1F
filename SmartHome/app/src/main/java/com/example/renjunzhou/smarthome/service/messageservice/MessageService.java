package com.example.renjunzhou.smarthome.service.messageservice;

import com.example.renjunzhou.smarthome.entity.Command;
import com.example.renjunzhou.smarthome.utils.AbstractAccess;
import com.example.renjunzhou.smarthome.utils.Encryped;

/**
 * Created by renjunzhou on 2016/12/27.
 *
 */

public class MessageService {
    private AbstractAccess _access;
    public MessageService(AbstractAccess access) {
        this._access = access;
    }


    public void sendMessage(String seed, String clearText) throws Exception {
        _access.sendMessage("["+encrypt(seed, clearText)+"]");
    }
    public String receiveMessage(String seed) throws Exception {
        return decrypt(seed,_access.receiveMessage());
    }


    private String encrypt(String seed,String cleartext) throws Exception {
        return Encryped.encrypt(seed,cleartext);
    }

    private String decrypt(String seed,String encrypted) throws Exception {
        return Encryped.decrypt(seed, encrypted);
    }


}
