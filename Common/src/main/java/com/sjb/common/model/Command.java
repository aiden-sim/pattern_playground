package com.sjb.common.model;

import java.io.Serializable;

public class Command implements Serializable {
    private static final long serialVersionUID = 1L;

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
