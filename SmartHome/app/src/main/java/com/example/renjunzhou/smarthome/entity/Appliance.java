package com.example.renjunzhou.smarthome.entity;

/**
 * Created by renjunzhou on 2016/12/27.
 */

public abstract class Appliance {
    private String _id;

    public void setId(String id){
        _id=id;
    }

    public String getId(){
        return _id;
    }
}
