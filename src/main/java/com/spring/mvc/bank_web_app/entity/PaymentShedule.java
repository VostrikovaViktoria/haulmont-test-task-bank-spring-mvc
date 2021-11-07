package com.spring.mvc.bank_web_app.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "payment_schedule")
public class PaymentShedule implements Comparable<PaymentShedule> {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "date_payment")
    private Date datePayment;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Column(name = "amount_body")
    private double amountBodyCredit;

    @Column(name = "amount_interest")
    private double amountInterset;

    public PaymentShedule() {
    }

    public PaymentShedule(Date datePayment, double paymentAmount, double amount_credit, double amount_interest) {
        this.datePayment = datePayment;
        this.paymentAmount = paymentAmount;
        this.amountBodyCredit = amount_credit;
        this.amountInterset = amount_interest;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date date_payment) {
        this.datePayment = date_payment;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double payment_amount) {
        this.paymentAmount = payment_amount;
    }

    public double getAmountBodyCredit() {
        return amountBodyCredit;
    }

    public void setAmountBodyCredit(double amount_credit) {
        this.amountBodyCredit = amount_credit;
    }

    public double getAmountInterset() {
        return amountInterset;
    }

    public void setAmountInterset(double amount_interset) {
        this.amountInterset = amount_interset;
    }

    @Override
    public String toString() {
        return "PaymentShedule{" +
                "id=" + id +
                ", date_payment=" + datePayment +
                ", payment_amount=" + paymentAmount +
                ", amount_body_credit=" + amountBodyCredit +
                ", amount_interset=" + amountInterset +
                '}';
    }

    @Override
    public int compareTo(PaymentShedule o) {
        return (int) -(this.amountInterset - o.amountInterset);
    }
}
