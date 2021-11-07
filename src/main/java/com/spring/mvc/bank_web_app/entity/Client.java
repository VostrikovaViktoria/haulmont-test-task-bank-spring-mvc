package com.spring.mvc.bank_web_app.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "surname")
    @Size(min = 2, message = "Длина фамилии должна быть не меньше 2!")
    private String surname;

    @Column(name = "name")
    @Size(min = 2, message = "Длина имени должна быть не меньше 2!")
    private String name;

    @Column(name = "middle_name")
    @Size(min = 2, message = "Длина отчества должна быть не меньше 2!")
    private String middleName;

    @Column(name = "phone")
    @Pattern(regexp = "89[0-9]{9}", message = "Номер телефона должен начинаться на 89" +
            "содержать 11 цифр!")
    private String phone;

    @Column(name = "email")
    @Email(message = "Неправильно указан адрес эл. почты!")
    private String email;

    @Column(name = "passport_number")
    @Pattern(regexp = "[0-9]{6}", message = "Номер паспорта должен содержать 6 цифр!")
    private String passportNumber;

    @OneToOne(cascade = CascadeType.ALL
            , mappedBy = "client")
    private CreditOffer creditOffer;

    public Client() {
    }

    public Client(String surname, String name, String middle_name, String phone, String email, String passport_number) {
        this.surname = surname;
        this.name = name;
        this.middleName = middle_name;
        this.phone = phone;
        this.email = email;
        this.passportNumber = passport_number;
    }

    public CreditOffer getCreditOffer() {
        return creditOffer;
    }

    public void setCreditOffer(CreditOffer creditOffer) {
        this.creditOffer = creditOffer;
    }

        public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middle_name) {
        this.middleName = middle_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passport_number) {
        this.passportNumber = passport_number;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middle_name='" + middleName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", passport_number='" + passportNumber + '\'' +
                '}';
    }
}
