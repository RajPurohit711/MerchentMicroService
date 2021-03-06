package com.example.MerchantDetails.Service;

import com.example.MerchantDetails.Dto.LoginDto;
import com.example.MerchantDetails.Dto.MerchantDetailDto;
import com.example.MerchantDetails.Entity.MerchantDetail;

public interface MerchantDetailService {
    MerchantDetail select(Long id);
    void save(MerchantDetail department);
    Iterable<MerchantDetail> findAll();
    void deleteById(Long id);
    public boolean exists(LoginDto loginDto);
    public MerchantDetail getMerchantByEmail(String email);

}
