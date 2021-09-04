package com.example.kafkademo.sender;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

@Component
public class KafkaMessageSender {


    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;

    /**
     *  发送消息到指定的topic主题
     * @param topicName 主题名称
     * @param messagePayload 消息主题信息
     */
    public void sendMessage(String topicName,Object messagePayload){
        kafkaTemplate.send(topicName,messagePayload);
    }
    /**
     *  发送消息到指定的topic主题
     * @param topicName 主题名称
     * @param messagePayload 消息主题信息
     */
    public void sendMessage2(String topicName,Object messagePayload){

        ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaTemplate.send(topicName, messagePayload);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            //发送消息失败回调
            @Override
            public void onFailure(Throwable throwable) {
                    throwable.printStackTrace();
            }
            //发送消息成功回调
            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //getRecordMetadata里面存在发送的topic和partition等信息
                System.out.println(stringObjectSendResult.getRecordMetadata());
                System.out.println("topic: "+stringObjectSendResult.getRecordMetadata().topic());
                System.out.println("offset: "+stringObjectSendResult.getRecordMetadata().offset());
                System.out.println("partition: "+stringObjectSendResult.getRecordMetadata().partition());
            }
        });
    }


}
