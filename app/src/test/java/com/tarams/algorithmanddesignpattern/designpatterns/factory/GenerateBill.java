package com.tarams.algorithmanddesignpattern.designpatterns.factory;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GenerateBill {
    @Test
    public void getBill() {
        GetPlanFactory planFactory = new GetPlanFactory();


        String planName = "COMMERCIALPLAN";
        int units = 500;

        Plan p = planFactory.getPlan(planName);
        //call getRate() method and calculateBill()method of DomesticPaln.

        System.out.print("Bill amount for " + planName + " of  " + units + " units is: ");
        p.getRate();
        p.calculateBill(units);
    }

}
