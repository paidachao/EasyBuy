package com.kgc.enums;

public enum IndexEnum {
    CATEGORY_PATH("../assets/images/");
    private String value;
    IndexEnum(String value) {
        this.value = value;
    }
    public String getPath() {
        return value;
    }
    @Override
    public String toString() {
        return value;
    }
}
