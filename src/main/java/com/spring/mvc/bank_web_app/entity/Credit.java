package com.spring.mvc.bank_web_app.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;


    @Column(name = "credit_limit")
    @DecimalMin(value = "50000", message = "Минимальная сумма кредита должна быть не меньше 50000 р.")
    private long creditLimit;

    @Column(name = "interset_rate")
    @DecimalMin(value = "0.1", message = "Процентная ставка должна быть не меньше 0.1%")
    private double intersetRate;

    public Credit() {
    }

    public Credit(long credit_limit, double interset_rate) {
        this.creditLimit = credit_limit;
        this.intersetRate = interset_rate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(long credit_limit) {
        this.creditLimit = credit_limit;
    }

    public double getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(double interset_rate) {
        this.intersetRate = interset_rate;
    }
}
