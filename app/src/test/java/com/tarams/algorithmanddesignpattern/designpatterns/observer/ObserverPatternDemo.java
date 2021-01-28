package com.tarams.algorithmanddesignpattern.designpatterns.observer;

import org.junit.Test;

public class ObserverPatternDemo {
    @Test
    public void observerTest() {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
