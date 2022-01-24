package com.example.MerchantDetails.Repository;

import com.example.MerchantDetails.Entity.MerchantDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDetailRepository extends CrudRepository<MerchantDetail,Long> {
    void deleteByEmailId(String id);
}
