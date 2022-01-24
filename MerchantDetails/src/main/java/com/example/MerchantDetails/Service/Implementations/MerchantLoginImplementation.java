package com.example.MerchantDetails.Service.Implementations;

import com.example.MerchantDetails.Dto.MerchantLoginDto;
import com.example.MerchantDetails.Entity.MerchantDetail;
import com.example.MerchantDetails.Entity.MerchantLogin;
import com.example.MerchantDetails.Repository.MerchantLoginRepository;
import com.example.MerchantDetails.Service.MerchantLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantLoginImplementation implements MerchantLoginService {

    @Autowired
    MerchantLoginRepository merchantLoginRepository;

    @Override
    public MerchantLogin finByEmailId(String mail) {
        return merchantLoginRepository.findByEmailId(mail);
    }

    @Override
    public MerchantLogin select(Long id) {
        return merchantLoginRepository.findById(id).get();
    }

    @Override
    public void save(MerchantLogin merchantLogin) {
        merchantLoginRepository.save(merchantLogin);
    }

    @Override
    public Iterable<MerchantLogin> findAll() {
        return merchantLoginRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        merchantLoginRepository.deleteById(id);
    }
}
