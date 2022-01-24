package com.example.MerchantDetails.Service;


import com.example.MerchantDetails.Dto.MerchantLoginDto;
import com.example.MerchantDetails.Entity.MerchantDetail;
import com.example.MerchantDetails.Entity.MerchantLogin;

public interface MerchantLoginService {
    MerchantLogin select(Long id);
    void save(MerchantLogin department);
    Iterable<MerchantLogin> findAll();
    void deleteById(Long id);
    MerchantLogin finByEmailId(String mail);
}
