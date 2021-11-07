package com.spring.mvc.bank_web_app.myClasses;

import org.springframework.stereotype.Component;


@Component
public class Repayments {

    private double intersetRate;

    private int paymentTerm;

    private long creditAmount;

    private double monthlyRepayment;

    public Repayments() {
    }

    public Repayments(double intersetRate, int paymentTerm, long creditAmount, double monthlyRepayment) {
        this.intersetRate = intersetRate;
        this.paymentTerm = paymentTerm;
        this.creditAmount = creditAmount;
        this.monthlyRepayment = monthlyRepayment;
    }

    @Override
    public String toString() {
        return "Repayments{" +
                "intersetRate=" + intersetRate +
                ", paymentTerm=" + paymentTerm +
                ", creditAmount=" + creditAmount +
                ", monthlyRepayment=" + monthlyRepayment +
                '}';
    }


    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public long getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(long creditAmount) {
        this.creditAmount = creditAmount;
    }

    public int getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(int paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public double getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(double intersetRate) {
        this.intersetRate = intersetRate;
    }
}
