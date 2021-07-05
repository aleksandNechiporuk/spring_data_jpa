package ru.aleksnech.springboot.spring_data_jpa.entity;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "client_credit")
public class ClientCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sur_name")
    private String surName;

    @Column(name = "email")
    private String email;

    @Column(name = "credit_amount")
    private Double creditAmount;

    @Column(name = "amount_debt")
    private Double amountDebt;

    @Column(name = "plateg")
    private Double plateg;

    @Column(name = "plateg_date")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date plateg_date;

    public ClientCredit() {
    }

    public ClientCredit(int id, String name, String lastName, String surName
            , String email, Double creditAmount, Double amountDebt
            , Double plateg, Date plateg_date) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.email = email;
        this.creditAmount = creditAmount;
        this.amountDebt = amountDebt;
        this.plateg = plateg;
        this.plateg_date = plateg_date;
    }

    public ClientCredit(String name, String lastName, String surName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.email = email;
    }

    public ClientCredit(Double plateg) {
        this.plateg = plateg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Double getAmountDebt() {
        return amountDebt;
    }

    public void setAmountDebt(Double amountDebt) {
        this.amountDebt = amountDebt;
    }

    public Double getPlateg() {
        return plateg;
    }

    public void setPlateg(Double plateg) {
        this.plateg = plateg;
    }

    public Date getPlateg_date() {
        return plateg_date;
    }

    public void setPlateg_date(Date plateg_date) {
        this.plateg_date = plateg_date;
    }

    @Override
    public String toString() {
        return "ClientCredit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", creditAmount=" + creditAmount +
                ", amountDebt=" + amountDebt +
                ", plateg=" + plateg +
                ", plateg_date=" + plateg_date +
                '}';
    }
}
