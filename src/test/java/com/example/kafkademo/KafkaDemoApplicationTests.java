package com.example.kafkademo;

import com.example.kafkademo.pojo.UserMessage;
import com.example.kafkademo.sender.KafkaMessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;


@SpringBootTest
public class KafkaDemoApplicationTests {

    @Autowired
    private KafkaMessageSender kafkaMessageSender;

    @Resource(name = "kafkaTemplate")
    private KafkaTemplate kafkaTemplate;

    /**
     * 测试发送主题
     * 没有主题会抛出异常
     */
    @Test
    public void sendMessage() {
        UserMessage message=new UserMessage();
        message.setId(1);
        message.setMessage("消息-1");
        kafkaMessageSender.sendMessage("userTopic",message);
    }
    /**
     * 测试发送主题
     * 没有主题会抛出异常
     */
    @Test
    public void sendMessage2() {

        for(int i=0;i<100 ;i++){
            kafkaTemplate.send("userTopic3",3,null,"消息"+i);
//            kafkaTemplate.send("userTopic3","消息"+i);
        }
    }
    /**
     * 测试发送主题
     * 没有主题会抛出异常
     */
    @Test
    public void sendMessage3() {

        for(int i=0;i<50 ;i++){
            kafkaTemplate.send("userTopic4","消息"+i);
            System.out.println("xxxxxxxxxxxx"+i);
//            kafkaTemplate.send("userTopic3","消息"+i);
        }
    }
}
