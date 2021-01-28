package com.tarams.algorithmanddesignpattern.designpatterns.adapter;

import org.junit.Test;

public class AdapterPatternDemo {
    @Test
    public void adapterTest(){
        CreditCard targetInterface=new BankCustomer();
        targetInterface.giveBankDetails();
        System.out.println(targetInterface.getCreditCard());
    }
}
