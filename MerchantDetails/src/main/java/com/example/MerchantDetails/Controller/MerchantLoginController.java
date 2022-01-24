package com.example.MerchantDetails.Controller;

import com.example.MerchantDetails.Dto.MerchantLoginDto;
import com.example.MerchantDetails.Entity.MerchantDetail;
import com.example.MerchantDetails.Entity.MerchantLogin;
import com.example.MerchantDetails.Service.MerchantLoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Merchant")
public class MerchantLoginController {
    @Autowired
    MerchantLoginService merchantLoginService;

    @GetMapping(value = "/count")
    int countOfMerchants()
    {
        Iterable<MerchantLogin> merchantLogins = merchantLoginService.findAll();
        int sum = 0;
        for(MerchantLogin org:merchantLogins)sum++;
        return sum;
    }

    @GetMapping(value = "/all")
    Iterable<MerchantLogin> findAll()
    {
        return merchantLoginService.findAll();
    }

    @GetMapping(value = "/{email}")
    MerchantLogin findByEmail(@PathVariable("email") String mail)
    {
        return merchantLoginService.finByEmailId(mail);
    }

    @GetMapping(value = "/password/{email}")
    String getPassword(@PathVariable("email") String mail)
    {
        MerchantLogin merchantLogin = findByEmail(mail);
        return merchantLogin.getPassword();
    }
}
