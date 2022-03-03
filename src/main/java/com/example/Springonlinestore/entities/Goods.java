package com.example.Springonlinestore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Category should not be blank!")
    private String category;
    @NotBlank(message = "Goods code should not be blank!")
    private String goodsCode;
    @NotBlank(message = "Color should not be blank!")
    private String color;
    @NotBlank(message = "Price should not be blank!")
    private Integer price;

    public Goods(String category, String goodsCode, String color, Integer price) {
        this.category = category;
        this.goodsCode = goodsCode;
        this.color = color;
        this.price = price;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "category='" + category + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
