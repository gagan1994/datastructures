package com.varmints.def.designpatterns.adapter;

import org.junit.Test;

public class AdapterPatternDemo {

    public void adapterTest(){
        CreditCard targetInterface=new BankCustomer();
        targetInterface.giveBankDetails();
        System.out.println(targetInterface.getCreditCard());
    }
}
