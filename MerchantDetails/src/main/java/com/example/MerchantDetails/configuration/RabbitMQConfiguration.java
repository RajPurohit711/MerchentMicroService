package com.example.MerchantDetails.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    public static final String ROUTING_MERCHANT_EMAIL ="routing.MerchantEmail";
    public static final String ROUTING_MERCHANT_ORDER ="routing.MerchantOrder";

    @Bean
    Queue queueMerchantEmail(){
        return new Queue("queue.MerchantEmail",false);
    }

    @Bean
    Queue queueMerchantOrder(){
        return new Queue("queue.MerchantOrder",false);
    }




    @Bean
    DirectExchange exchange(){
        return new DirectExchange("direct.exchange");
    }

    @Bean
    Binding bindingMerchantEmail(Queue queueMerchantEmail, DirectExchange exchange){
        return BindingBuilder.bind(queueMerchantEmail).to(exchange).with(ROUTING_MERCHANT_EMAIL);
    }

    @Bean
    Binding bindingMerchantOrder(Queue queueMerchantOrder, DirectExchange exchange){
        return BindingBuilder.bind(queueMerchantOrder).to(exchange).with(ROUTING_MERCHANT_ORDER);
    }



    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
