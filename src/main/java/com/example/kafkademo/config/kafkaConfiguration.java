package com.example.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaConfiguration {

    @Bean
    public NewTopic userTopic(){
        //基于构建器，创建主题
        return TopicBuilder.name("userTopic2").build();

        //return new NewTopic("userTopic",1, (short) 0);
    }

}
