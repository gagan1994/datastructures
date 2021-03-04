package com.varmints.def.designpatterns.builder;

import org.junit.Test;

public class BuilderDemo {

    public void testBuilder() {
        CDBuilder cdBuilder = new CDBuilder();
        CDType cdType1 = cdBuilder.buildSonyCD();
        cdType1.showItems();

        CDType cdType2 = cdBuilder.buildSamsungCD();
        cdType2.showItems();
    }
}
