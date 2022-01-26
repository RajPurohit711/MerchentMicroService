package com.example.MerchantDetails.Controller;

import com.example.MerchantDetails.Dto.LoginDto;
import com.example.MerchantDetails.Dto.MerchantDetailDto;
import com.example.MerchantDetails.Dto.OtpDto;
import com.example.MerchantDetails.Dto.ValidateOtpDto;
import com.example.MerchantDetails.Entity.MerchantDetail;
import com.example.MerchantDetails.Service.MerchantDetailService;
import net.minidev.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(value = "/merchant")
public class MerchantDetailController {
    @Autowired
    MerchantDetailService merchantDetailService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchange;

    OtpDto otpDto=new OtpDto();


    @GetMapping(value = "/{id}")
    MerchantDetailDto getMerchantById(@PathVariable("id") Long id)
    {
        MerchantDetail merchantDetail = merchantDetailService.select(id);
        MerchantDetailDto merchantDetailDto = new MerchantDetailDto();
        BeanUtils.copyProperties(merchantDetail,merchantDetailDto);
        return merchantDetailDto;
    }



    @RequestMapping(value={"/register"},method = {RequestMethod.POST,RequestMethod.PUT})
    JSONObject registerMerchant(@RequestBody ValidateOtpDto validateOtpDto){
        JSONObject jsonObject=new JSONObject();
        if (validateOtpDto.getPassword().equals(validateOtpDto.getConfirmPassword())){
            Random rnd = new Random();
            Long number = Long.valueOf(new Random().nextInt(900000) + 100000);
            otpDto.setOtp(number);
            String email=validateOtpDto.getEmail();
            otpDto.setEmail(email);
            rabbitTemplate.convertAndSend(exchange.getName(),"routing.MerchantEmail",otpDto);
            String enOtp=BCrypt.hashpw(number.toString(),BCrypt.gensalt());
            jsonObject.put("status",201);
            jsonObject.put("enOtp",enOtp);
            return jsonObject;
        }
        jsonObject.put("status",500);
        return jsonObject;
    }

    @RequestMapping(value={"/verify"},method = {RequestMethod.POST,RequestMethod.PUT})
    JSONObject verifyAndRegister(@RequestBody ValidateOtpDto validateOtpDto){

        JSONObject jsonObject=new JSONObject();
        if (BCrypt.checkpw(String.valueOf(validateOtpDto.getOtp()),validateOtpDto.getEnOtp())){
            MerchantDetail merchantDetail =new MerchantDetail();
            String password=validateOtpDto.getPassword();
            String enPassword=BCrypt.hashpw(password,BCrypt.gensalt());
            validateOtpDto.setPassword(enPassword);
            BeanUtils.copyProperties(validateOtpDto,merchantDetail);
            merchantDetail.setSellerSince(java.time.LocalDate.now());
            merchantDetailService.save(merchantDetail);
            jsonObject.put("status",201);
            return jsonObject;
        }
        jsonObject.put("status",500);
        return jsonObject;

    }

    @RequestMapping(value={"/login"},method = {RequestMethod.POST,RequestMethod.PUT})
    JSONObject authenticateMerchant(@RequestBody LoginDto loginDto) {
        JSONObject jsonObject=new JSONObject();
        if(merchantDetailService.exists(loginDto))
        {
            jsonObject.put("status",201);
            return jsonObject;
        }
        jsonObject.put("status",500);
        return jsonObject;
    }





    @DeleteMapping(value = "/{id}")
    void deleteById(@PathVariable Long id)
    {
        merchantDetailService.deleteById(id);
    }

    @GetMapping(value = "byEmail/{id}")
    MerchantDetailDto findMerchantByEmailId(@PathVariable("id") String id)
    {
        MerchantDetailDto merchantDetailDto=new MerchantDetailDto();
        MerchantDetail merchantDetail=merchantDetailService.getMerchantByEmail(id);
        BeanUtils.copyProperties(merchantDetail,merchantDetailDto);
        return  merchantDetailDto;
    }

    @GetMapping(value = "/all")
    Iterable<MerchantDetail> findAll()
    {
        return merchantDetailService.findAll();
    }

}



