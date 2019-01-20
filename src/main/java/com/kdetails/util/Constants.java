package com.kdetails.util;

public enum Constants {

    KEY_VALUE_SEPARATOR("="),
    MAP_ENTRY_SEPARATOR(";"),
    ARRAY_SEPARATOR("\n"),
    REGEX_TO_REPLACE_BEFORE(".*="),
    REGEX_TO_REPLACE_AFTER("=.*");

    private String value;

    public String getValue() {
        return this.value;
    }

    Constants(String value) {
        this.value = value;
    }
}
