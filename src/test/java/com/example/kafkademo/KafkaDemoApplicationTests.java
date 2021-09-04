package com.example.kafkademo;

import com.example.kafkademo.pojo.UserMessage;
import com.example.kafkademo.sender.KafkaMessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaDemoApplicationTests {

    @Autowired
    private KafkaMessageSender kafkaMessageSender;

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
        UserMessage message=new UserMessage();
        message.setId(1);
        message.setMessage("消息-1");
        kafkaMessageSender.sendMessage2("userTopic2",message);
    }


}
