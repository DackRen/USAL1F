package com.example.renjunzhou.smarthome.entity;

/**
 * Created by renjunzhou on 2016/12/27.
 */

public class Message {
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String _content) {
        this._content = _content;
    }

    private String _id;
    private String _content;
}
