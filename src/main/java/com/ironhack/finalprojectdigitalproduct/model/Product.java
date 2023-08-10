package com.ironhack.finalprojectdigitalproduct.model;


import java.util.List;

public class Product extends BaseEntity{
    private Long id;
    private String name;
    private String description;
    private String productNumber;
    private List<Review> reviews;
    private List<Search> searchs;

}
