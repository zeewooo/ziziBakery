package com.thymeleaf.study.domain;

import lombok.Data;

@Data
public class Product {
    int uid;
    int category_uid;
    String name;
    int price;


}
