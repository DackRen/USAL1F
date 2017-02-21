package com.example.renjunzhou.smarthome.entity;

/**
 * Created by renjunzhou on 2016/12/27.
 */

public enum Command {
    TURN_ON("<ON>"),
    TURN_OFF("<OF>"),
    //TODO:add 0~255 change of level on seekBar
    //<FF+number>
    CHANGE_LEVEL_FREE("FF"),
    CHANGE_LEVEL_1("<OnS>"),
    CHANGE_LEVEL_2("<OnM>"),
    CHANGE_LEVEL_3("<OnL>"),
    CHANGE_MOOD_1("<OnA>"),//呼吸灯
    CHANGE_MOOD_2("<onW>"),//三个灯都有变化
    CHANGE_MOOD_3("<onN>"),//onN,both mid level
    CHANGE_MOOD_4("<onG>");//onG,both low level

    Command(String command) {
        this._command = command;
    }

    private String _command;

    public String getCommand() {
        return _command;
    }
}
