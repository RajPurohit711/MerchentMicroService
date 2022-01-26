package com.example.MerchantDetails.Service.Implementations;

import com.example.MerchantDetails.Entity.MerchantHistory;
import com.example.MerchantDetails.Repository.MerchantHistoryRepository;
import com.example.MerchantDetails.Service.MerchantHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantHistoryImpl implements MerchantHistoryService {
    @Autowired
    MerchantHistoryRepository merchantHistoryRepository;
//    @Override
//    public MerchantHistory findByIds(Long merchantId,String productId){
//        return merchantHistoryRepository.findByIds(merchantId,productId);
//    }
    public void save(MerchantHistory merchantHistory){
        merchantHistoryRepository.save(merchantHistory);
    }
}
