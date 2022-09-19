package com.example.kafkademo;

import com.example.kafkademo.pojo.UserMessage;
import org.assertj.core.util.Lists;

import java.io.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Test {

    public static void main(String[] args) throws IOException {

//        File temp = File.createTempFile("12312222222222222", ".pdf",new File("E://"));
//
//        FileOutputStream fileOutputStream=new FileOutputStream(temp);
//        System.out.println("文件路径: "+temp.getAbsolutePath());
//        fileOutputStream.flush();
//        fileOutputStream.close();

//        List<Long> templatepOfFillableItemId = Lists.newArrayList();
//        //普通条款ID对应的可填项Id集合
//        List<Long> commmonTermOfFillableItemId = Lists.newArrayList();
//        // 并集
//        templatepOfFillableItemId.addAll(commmonTermOfFillableItemId);
//        // 去重并集
//        List<Long> listAllDistinct = templatepOfFillableItemId.stream().distinct().collect(toList());
//        System.out.println(listAllDistinct.size());
//        if (CollectionUtils.isEmpty(listAllDistinct)) {
//            System.out.println(123123);
//        }
        List<UserMessage> userMessages = Lists.newArrayList();
//        UserMessage userMessage=new UserMessage();
//        userMessage.setId(1);
//        userMessage.setMessage("ces");
//        UserMessage userMessage2=new UserMessage();
//        userMessage2.setId(2);
//        userMessage2.setMessage("ces2");
//        UserMessage userMessage3=new UserMessage();
//        userMessage3.setId(1);
//        userMessage3.setMessage("ces3");
//        userMessages.add(userMessage);
//        userMessages.add(userMessage2);
//        userMessages.add(userMessage3);
        List<Long> oldTermids = Lists.newArrayList();
        List<Integer> fillableItemIds = userMessages.stream().map(UserMessage::getId).collect(toList());
        System.out.println(fillableItemIds.size());
        for (Integer name:
        fillableItemIds) {
            System.out.println(name);
        }
    }
}
