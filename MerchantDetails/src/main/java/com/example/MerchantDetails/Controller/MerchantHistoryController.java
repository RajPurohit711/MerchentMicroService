package com.example.MerchantDetails.Controller;

import com.example.MerchantDetails.Dto.MerchantHistoryDto;
import com.example.MerchantDetails.Entity.MerchantHistory;
import com.example.MerchantDetails.Service.MerchantHistoryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/merchantHistory")
public class MerchantHistoryController {

    @Autowired
    MerchantHistoryService merchantHistoryService;
    @RabbitListener(queues = "queue.MerchantOrder")
    public void receiveOrderHistory(MerchantHistoryDto merchantHistoryDto){
        MerchantHistory merchantHistory=new MerchantHistory();
        BeanUtils.copyProperties(merchantHistoryDto,merchantHistory);
        merchantHistoryService.save(merchantHistory);
        }
}
