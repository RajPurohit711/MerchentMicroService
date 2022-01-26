package com.example.MerchantDetails.Service.Implementations;

import com.example.MerchantDetails.Dto.LoginDto;
import com.example.MerchantDetails.Dto.MerchantDetailDto;
import com.example.MerchantDetails.Entity.MerchantDetail;
import com.example.MerchantDetails.Repository.MerchantDetailRepository;
import com.example.MerchantDetails.Service.MerchantDetailService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantDetailImplementation implements MerchantDetailService {
    @Autowired
    MerchantDetailRepository merchantDetailRepository;

    @Override
    public MerchantDetail select(Long id) {
        return merchantDetailRepository.findById(id).get();
    }

    @Override
    public void save(MerchantDetail merchantDetail) {
        merchantDetailRepository.save(merchantDetail);
    }

    @Override
    public Iterable<MerchantDetail> findAll() {
        return merchantDetailRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        merchantDetailRepository.deleteById(id);
    }

    @Override
    public boolean exists(LoginDto loginDto){
        MerchantDetail merchantDetail=merchantDetailRepository.findByEmail(loginDto.getEmail());
        if (BCrypt.checkpw(String.valueOf(merchantDetail.getPassword()),loginDto.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public MerchantDetail getMerchantByEmail(String email) {
        return merchantDetailRepository.findByEmail(email);
    }


}
