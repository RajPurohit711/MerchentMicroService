package com.example.MerchantDetails.Repository;

import com.example.MerchantDetails.Dto.MerchantLoginDto;
import com.example.MerchantDetails.Entity.MerchantLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantLoginRepository extends CrudRepository<MerchantLogin,Long> {
    MerchantLogin findByEmailId(String mail);
}
