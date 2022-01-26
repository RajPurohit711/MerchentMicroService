package com.example.MerchantDetails.Repository;

import com.example.MerchantDetails.Entity.MerchantHistory;
import org.springframework.data.repository.CrudRepository;

public interface MerchantHistoryRepository extends CrudRepository<MerchantHistory,Long> {
//    MerchantHistory findByIds(Long merchantId,String productId);
}
