package com.campus2020.restclient.model;


import javax.persistence.*;


@Entity
@Table(name = "cars")

public class Car {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "brand", length = 255, nullable = false)
    private String brand;

    @Column(name = "version", length = 255, nullable = false)
    private String version;


    public Car() {

    }

    public Car(String brand, String version) {
        this.brand = brand;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override

    public String toString() {
        return "Car{" +
                "id= " + id +
                ", brand= " + brand + '\'' +
                ", version= " + version + '}';
    }

}