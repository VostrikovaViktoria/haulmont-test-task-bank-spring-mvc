package com.spring.mvc.bank_web_app.myClasses;

import com.spring.mvc.bank_web_app.entity.Credit;

import java.util.List;

public class Calculation {

    public static Credit getRate(List<Credit> creditList, long creditAmount){
        Credit min_credit = null;
        double min_limit = Double.POSITIVE_INFINITY;
        for (Credit c: creditList) {
            long limit = c.getCreditLimit();
            if ((limit >= creditAmount) && (limit < min_limit)){
                min_limit = limit;
                min_credit = c;
            }
        }
        return min_credit;
    }

    public static double calcMonthRepayment(long creditAmount, double interRate, int years){
        double rate = interRate / 100 / 12;
        return aroundNumber(creditAmount * (rate + (rate / (Math.pow(1 + rate, years * 12) - 1))), 2);
    }

    public static double calcBodyCredit(double monthAmount, double proc){
        return aroundNumber(monthAmount - proc, 2);
    }

    public static double calcIntersetCredit(double remAmount, double interRate){
        return aroundNumber(remAmount / interRate / 12, 2);
    }

    public static double aroundNumber(double value, int sc){
        double scale = Math.pow(10, sc);
        return Math.ceil(value * scale) / scale;
    }


}
