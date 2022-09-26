package com.example.kafkademo.consuner;

import com.example.kafkademo.pojo.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author user
 */
@Component
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "userTopic",groupId = "user-group-id-2")
    public void onMessage(UserMessage message){
        System.out.println("消费信息=======================");
        System.out.println(message);

    }

    /**
     * 批量消费
     * @param consumerRecords
     * @param ack
     */
    @KafkaListener(groupId = "groupId03", topics = "userTopic3",containerFactory="batchFactory")
    public void consumeTopic07(List<ConsumerRecord<String, Object>> consumerRecords, Acknowledgment ack) {
        System.out.println(consumerRecords.size() + "条数被消费");
        if (consumerRecords != null) {
            System.out.println("userTopic3-" + consumerRecords.size());
            for (ConsumerRecord record : consumerRecords) {
                log.info(Thread.currentThread().getName());
                log.info("拉取的消息：partition = {}, offset = {}, key = {}, value = {}", record.partition(), record.offset(), record.key(), record.value());
            }
            ack.acknowledge();
        }

    }

    /**
     * 批量消费
     * @param consumerRecords
     * @param ack
     */
    @KafkaListener(groupId = "groupId04", topics = "userTopic4",containerFactory="batchFactory")
    public void userTopic4(List<ConsumerRecord<String, Object>> consumerRecords, Acknowledgment ack) {
        System.out.println(consumerRecords.size() + "条数被消费");
        if (consumerRecords != null) {
            for (ConsumerRecord record : consumerRecords) {
                log.info(Thread.currentThread().getName());
                log.info("拉取的消息：partition = {}, offset = {}, key = {}, value = {}", record.partition(), record.offset(), record.key(), record.value());
            }
            ack.acknowledge();
        }

    }
}
