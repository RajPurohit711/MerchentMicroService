package com.example.MerchantDetails.Controller;

import com.example.MerchantDetails.Dto.MerchantDetailDto;
import com.example.MerchantDetails.Dto.MerchantRegisterDto;
import com.example.MerchantDetails.Entity.MerchantDetail;
import com.example.MerchantDetails.Entity.MerchantLogin;
import com.example.MerchantDetails.Service.MerchantDetailService;
import com.example.MerchantDetails.Service.MerchantLoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Detail")
public class MerchantDetailController {
    @Autowired
    MerchantDetailService merchantDetailService;

    @Autowired
    MerchantLoginService merchantLoginService;

    @GetMapping(value = "/{id}")
    MerchantDetailDto select(@PathVariable("id") Long id)
    {
        MerchantDetail merchantDetail = merchantDetailService.select(id);
        MerchantDetailDto organisationDto = new MerchantDetailDto();
        BeanUtils.copyProperties(merchantDetail,organisationDto);
        return organisationDto;
    }

    @RequestMapping(value = "/save",method = {RequestMethod.PUT,RequestMethod.POST})
    void save(@RequestBody MerchantRegisterDto merchantRegisterDto)
    {
        MerchantDetail merchantDetail = new MerchantDetail();
        MerchantLogin merchantLogin = new MerchantLogin();
        BeanUtils.copyProperties(merchantRegisterDto, merchantDetail);
        BeanUtils.copyProperties(merchantRegisterDto,merchantLogin);
        merchantDetailService.save(merchantDetail);
        merchantLoginService.save(merchantLogin);
    }

    @GetMapping(value = "/count")
    int countOfMerchants()
    {
        Iterable<MerchantDetail> organisations = merchantDetailService.findAll();
        int sum = 0;
        for(MerchantDetail org:organisations)sum++;
        return sum;
    }

    @GetMapping(value = "/all")
    Iterable<MerchantDetail> findAll()
    {
        return merchantDetailService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    void deleteById(@PathVariable Long id)
    {
        merchantDetailService.deleteById(id);
    }

    @GetMapping(value = "byEmail/{id}")
    MerchantDetailDto findByEmailId(@PathVariable("id") String id)
    {
        Iterable<MerchantDetail> merchantDetails = merchantDetailService.findAll();
        for(MerchantDetail merchantDetail:merchantDetails)
        {
            String mail = merchantDetail.getEmailId();
            if(mail.equals(id))
            {
                return select(merchantDetail.getId());
            }
        }
        return null;
    }

    @GetMapping(value = "byName/{id}")
    MerchantDetailDto findByName(@PathVariable("id") String id)
    {
        Iterable<MerchantDetail> merchantDetails = merchantDetailService.findAll();
        for(MerchantDetail merchantDetail:merchantDetails)
        {
            String mail = merchantDetail.getName();
            if(mail.equals(id))
            {
                return select(merchantDetail.getId());
            }
        }
        return null;
    }
}
