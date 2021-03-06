package com.example.MerchantDetails.Controller;

import com.example.MerchantDetails.Dto.OtpDto;
import com.example.MerchantDetails.Dto.UpdatePasswordDto;
import com.example.MerchantDetails.Entity.MerchantDetail;
import com.example.MerchantDetails.Service.MerchantDetailService;
import net.minidev.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value="/password")
public class PasswordController {
    @Autowired
    MerchantDetailService merchantDetailService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchange;

    OtpDto otpDto=new OtpDto();



    @RequestMapping(value={"/otp"},method = {RequestMethod.POST,RequestMethod.PUT})
    JSONObject forgotPassword(@RequestBody String email){
        JSONObject jsonObject=new JSONObject();
        Random rnd = new Random();
        int number = new Random().nextInt(900000) + 100000;
        otpDto.setOtp((long) number);
        otpDto.setEmail(email);
        rabbitTemplate.convertAndSend(exchange.getName(),"routing.MerchantEmail",otpDto);
        jsonObject.put("status",201);
        return jsonObject;
    }

    @RequestMapping(value={"/verify"},method = {RequestMethod.POST,RequestMethod.PUT})
    JSONObject verifyAndUpdatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){

        JSONObject jsonObject=new JSONObject();
        if (BCrypt.checkpw(String.valueOf(updatePasswordDto.getOtp()),updatePasswordDto.getEnOtp())){
            MerchantDetail merchantDetail = merchantDetailService.getMerchantByEmail(updatePasswordDto.getEmail());
            String password=updatePasswordDto.getPassword();
            String enPassword=BCrypt.hashpw(password,BCrypt.gensalt());
            updatePasswordDto.setPassword(enPassword);
            BeanUtils.copyProperties(updatePasswordDto,merchantDetail);
            merchantDetailService.save(merchantDetail);
            jsonObject.put("status",201);
            return jsonObject;
        }
        jsonObject.put("status",500);
        return jsonObject;

    }
}


//
//    @RequestMapping(value={"/update"},method = {RequestMethod.POST,RequestMethod.PUT})
//    JSONObject updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
//        JSONObject jsonObject=new JSONObject();
//        EndUser endUser= userService.getUserByEmail(updatePasswordDto.getEmail());
//        if (endUser.getPassword().equals(updatePasswordDto.getOldPassword())){
//            if(updatePasswordDto.getNewPassword().equals(updatePasswordDto.getConfirmNewPassword())){
//                endUser.setPassword(updatePasswordDto.getNewPassword());
//                jsonObject.put("status",201);
//                return jsonObject;
//            }
//        }
//        jsonObject.put("status",500);
//        return jsonObject;
//
//    }
