package com.example.kafkademo.consuner;

import com.example.kafkademo.pojo.UserMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author user
 */
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "userTopic",groupId = "user-group-id-2")
    public void onMessage(UserMessage message){
        System.out.println("消费信息=======================");
        System.out.println(message);

    }
}
