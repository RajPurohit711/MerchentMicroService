package com.example.MerchantDetails.Entity;

public class MerchantRegisterEntity {
    private String emailId;
    private String password;
    private Long phoneNumber;
    private String name;
    private String address;
    private Double rating;
    private Long numberOfProducts;
    private Long productsSold;
    private Long sellerSince;
    private String description;
    private String profileImg;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Long numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public Long getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Long productsSold) {
        this.productsSold = productsSold;
    }

    public Long getSellerSince() {
        return sellerSince;
    }

    public void setSellerSince(Long sellerSince) {
        this.sellerSince = sellerSince;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}
