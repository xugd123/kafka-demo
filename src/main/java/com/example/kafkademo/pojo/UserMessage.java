package com.example.kafkademo.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserMessage implements Serializable {

    private Integer id;

    private String message;


}
