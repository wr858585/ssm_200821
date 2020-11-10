package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 * @author oono
 * @date 2020 11 09
 */
public class Book {

    private Integer id;
    private Integer sales;
    private Integer stock;
    private String name;
    private String author;
    private BigDecimal price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", sales=" + sales +
                ", stock=" + stock +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Book(Integer id, Integer sales, Integer stock, String name, String author, BigDecimal price) {
        this.id = id;
        this.sales = sales;
        this.stock = stock;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }
}
