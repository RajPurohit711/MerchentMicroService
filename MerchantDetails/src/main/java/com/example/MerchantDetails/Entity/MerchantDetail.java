package com.example.MerchantDetails.Entity;

import com.example.MerchantDetails.Dto.MerchantDetailDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table
@Entity
public class MerchantDetail extends MerchantDetailDto {
    @Id
    @GeneratedValue(generator = "seq_gen_alias")
    @GenericGenerator(name="seq_gen_alias",strategy = "increment")
    private Long id;
    @Column(unique = true,nullable = false)
    private String emailId;

    @Column(nullable = false,unique = true)
    private Long phoneNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;

    private Long sellerSince;
    private String description;
    private String profileImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
