package com.tarams.algorithmanddesignpattern.designpatterns.adapter;

public class BankCustomer  extends BankDetails implements CreditCard {
    public void giveBankDetails(){
        try{

            String customername="gagan";

            long accno=12345678;

            String bankname="sbi";

            setAccHolderName(customername);
            setAccNumber(accno);
            setBankName(bankname);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public String getCreditCard() {
        long accno=getAccNumber();
        String accholdername=getAccHolderName();
        String bname=getBankName();

        return ("The Account number "+accno+" of "+accholdername+" in "+bname+
                "bank is valid and authenticated for issuing the credit card.");
    }
}