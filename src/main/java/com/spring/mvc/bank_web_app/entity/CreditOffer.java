package com.spring.mvc.bank_web_app.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "credit_offer")
public class CreditOffer {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_credit")
    private Credit credit;

    @Column(name = "credit_amount")
    private long creditAmount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_schedule")
    private List<PaymentShedule> sheduleList;

    public CreditOffer() {
    }

    public CreditOffer(Client client, Credit credit, long credit_amount, List<PaymentShedule> sheduleList) {
        this.client = client;
        this.credit = credit;
        this.creditAmount = credit_amount;
        this.sheduleList = sheduleList;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public long getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(long credit_amount) {
        this.creditAmount = credit_amount;
    }

    public List<PaymentShedule> getSheduleList() {

        return sheduleList;
    }

    public void setSheduleList(List<PaymentShedule> sheduleList) {
        this.sheduleList = sheduleList;
    }

    @Override
    public String toString() {
        return "CreditOffer{" +
                "id=" + id +
                ", client=" + client +
                ", credit=" + credit +
                ", credit_amount=" + creditAmount +
                ", sheduleList=" + sheduleList +
                '}';
    }
}
