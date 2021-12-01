package com.example.avia.models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Base64;

@Entity
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String transmission;
    private Integer year;
    private String price;
    private String pdfId;
    private String description;
    @Lob
    private byte[] image;


    public Cars() {

    }

    public Cars(Long id, String brand, String model, String transmission, Integer year, String price, String description, byte[] image, String pdf) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.transmission = transmission;
        this.year = year;
        this.price = price;
        this.description = description;
        this.image = image;
        this.pdfId = pdf;
    }

    public Cars(String brand, String model, String transmission, Integer year, String price, String description, byte[] image, String pdf) {
        this.brand = brand;
        this.model = model;
        this.transmission = transmission;
        this.year = year;
        this.price = price;
        this.description = description;
        this.image = image;
        this.pdfId = pdf;
    }

    public String getPdf() {
        return pdfId;
    }

    public void setPdf(String pdf) {
        this.pdfId = pdf;
    }

    public String getImgData(byte[] byteData) { return Base64.getMimeEncoder().encodeToString(byteData); }
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
