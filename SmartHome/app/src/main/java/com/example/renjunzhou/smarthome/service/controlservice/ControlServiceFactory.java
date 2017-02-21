package com.example.renjunzhou.smarthome.service.controlservice;

import com.example.renjunzhou.smarthome.utils.AbstractAccess;

/**
 * Created by renjunzhou on 2016/12/27.
 */

public class ControlServiceFactory {
    private static IControlService iControlService = null;
    public IControlService createControlService(AbstractAccess access){
        iControlService = new LightControlService(access);
        return iControlService;
    }
}
