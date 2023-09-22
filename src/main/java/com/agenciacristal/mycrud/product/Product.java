package com.agenciacristal.mycrud.product;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.annotation.processing.Generated;


import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) //definiendo campos unicos, para reguntrar por el nombre del prod antes de registrarlo
    private String name;
    private float price;
    private LocalDate date_created;
    @Transient//este campo no se debe crear en la tabla
    private int antiquity;


    public Product() {
    }

    public Product(Long id, String name, float price, LocalDate date_created) {
        this.id = id;
        this.name = name;
        this.price = price; //parar envia datos por datos,
        this.date_created = date_created;
    }

    public Product(String name, float price, LocalDate date_created) {
        this.name = name;
        this.price = price;//enviar todos menos el id
        this.date_created = date_created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public int getAntiquity() {

        return Period.between(this.date_created,LocalDate.now()).getYears();
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }
}
