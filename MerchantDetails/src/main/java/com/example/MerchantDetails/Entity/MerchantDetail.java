package com.example.MerchantDetails.Entity;

import com.example.MerchantDetails.Dto.MerchantDetailDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class MerchantDetail {
    @Id
    @GeneratedValue(generator = "seq_gen_alias")
    @GenericGenerator(name="seq_gen_alias",strategy = "increment")
    private Long id;

    @Column(unique =true,nullable = false,length = 100)
    private String email;
    @Column(nullable = false,length = 200)
    private String name;
    @Column(length = 2048)
    private String address;
    @Column(length=10)
    private String rating;
    @Column(length=15)
    private LocalDate sellerSince;
    @Column(unique =true,nullable = false,length=20)
    private Long phoneNo;
    @Column(length=2048)
    private String description;
    @Column(length=2048)
    private String profileImage;
    @Column(nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getSellerSince() {
        return sellerSince;
    }

    public void setSellerSince(LocalDate sellerSince) {
        this.sellerSince = sellerSince;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
