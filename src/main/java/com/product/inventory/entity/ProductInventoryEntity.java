package com.product.inventory.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "t_product_inventory")
public class ProductInventoryEntity {
    @Id
    @GeneratedValue
    @Column(name= "Code")
    private Long code;

    @Column(name= "Name")
    private String name;

    @Column(name= "Batch")
    private String batch;

    @Column(name= "Stock")
    private int stock;

    @Column(name= "Deal")
    private int deal;

    @Column(name= "Free")
    private int free;

    @Column(name= "MRP")
    private float mrp;

    @Column(name= "Rate")
    private float rate;

    @Column(name= "Expiry")
    private Date expiry;

    @Column(name= "Company")
    private String company;

    @Column(name= "Supplier")
    private String supplier;


    public ProductInventoryEntity() {
    }


    public ProductInventoryEntity(Long code, String name, String batch, int stock, int deal, int free,
                                  float mrp, float rate, Date expiry, String company, String supplier) {
        this.code = code;
        this.name = name;
        this.batch = batch;
        this.stock = stock;
        this.deal = deal;
        this.free = free;
        this.mrp = mrp;
        this.rate = rate;
        this.expiry = expiry;
        this.company = company;
        this.supplier = supplier;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDeal() {
        return deal;
    }

    public void setDeal(int deal) {
        this.deal = deal;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }


    public String getCompany() {
        return company;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }



    @Override
    public String toString() {
        return "ProductInventoryEntity{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", batch='" + batch + '\'' +
                ", stock=" + stock +
                ", deal=" + deal +
                ", free='" + free + '\'' +
                ", mrp=" + mrp +
                ", rate=" + rate +
                ", expiry='" + expiry + '\'' +
                ", company='" + company + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }



}
