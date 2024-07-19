package com.asemokamichi.entity;

public class Product {
    private Long id;
    private String name;
    private Long price;
    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
