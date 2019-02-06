package com.sjb.common.model;

public enum CommandType {
    REALTIME("realtime"),
    ANALYSIS("analysis");

    private String desc;

    CommandType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
