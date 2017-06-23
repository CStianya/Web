package com.dao.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by CS on 2017/6/22.
 */
public class Product implements Serializable {

    private long id;

    @NotNull(message = "用户名不得为空！")
    private String name;

    @Size(min = 0, max = 10, message = "最大长度不能超过10个字符！")
    private String description;

    private float price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
