package com.varmints.def.designpatterns.singleton;

public class SigleTonClass {
    private static SigleTonClass instance;

    public static SigleTonClass getInstance() {
        if (instance == null) {
            synchronized (SigleTonClass.class) {
                if (instance == null) {
                    instance = new SigleTonClass();
                }
            }
        }
        return instance;
    }
}
