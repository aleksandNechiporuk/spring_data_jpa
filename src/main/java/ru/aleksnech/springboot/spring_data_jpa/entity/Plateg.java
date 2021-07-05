package ru.aleksnech.springboot.spring_data_jpa.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "plateg_client")
public class Plateg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "plateg_client")
    private Double plategClient;

    @Column(name = "date_plateg")
    private Date datePlateg;

    @Column(name = "date_upwork")
    private Date dateUpWork;


    public Plateg() {
    }

    public Plateg(int id, int clientId, Double plategClient, Date datePlateg, Date dateUpWork) {
        this.id = id;
        this.clientId = clientId;
        this.plategClient = plategClient;
        this.datePlateg = datePlateg;
        this.dateUpWork = dateUpWork;
    }

    public Plateg(int clientId, Double plategClient, Date datePlateg, Date dateUpWork) {
        this.clientId = clientId;
        this.plategClient = plategClient;
        this.datePlateg = datePlateg;
        this.dateUpWork = dateUpWork;
    }

    public Date getDateUpWork() {
        return dateUpWork;
    }

    public void setDateUpWork(Date dateUpWork) {
        this.dateUpWork = dateUpWork;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Double getPlategClient() {
        return plategClient;
    }

    public void setPlategClient(Double plategClient) {
        this.plategClient = plategClient;
    }

    public Date getDatePlateg() {
        return datePlateg;
    }

    public void setDatePlateg(Date datePlateg) {
        this.datePlateg = datePlateg;
    }

    @Override
    public String toString() {
        return "Plateg{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", plategClient=" + plategClient +
                ", datePlateg=" + datePlateg +
                '}';
    }
}
