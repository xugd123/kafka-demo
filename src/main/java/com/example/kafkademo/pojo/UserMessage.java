package com.example.kafkademo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author user
 */
@Data
public class UserMessage implements Serializable {

    private Integer id;

    private Long  sex;

    private String message;

    public static void main(String[] args) {


        List<UserMessage> personList = new ArrayList<>();
        UserMessage userMessage = new UserMessage();
        userMessage.setId(1);
        userMessage.setSex(1L);
        userMessage.setMessage("1X");

        UserMessage userMessage2 = new UserMessage();
        userMessage2.setId(2);
        userMessage2.setSex(1L);
        userMessage2.setMessage("2X");

        UserMessage userMessage3 = new UserMessage();
        userMessage3.setId(3);
        userMessage3.setMessage("ccc");

        UserMessage userMessage4 = new UserMessage();
        userMessage4.setId(1);
        userMessage4.setSex(null);
        userMessage4.setMessage("YYY");

        personList.add(userMessage);
        personList.add(userMessage2);
        personList.add(userMessage3);
        personList.add(userMessage4);
//        //进行分组
//        Map<Integer, List<UserMessage>> collect = personList.stream().collect(Collectors.groupingBy(p -> p.id, Collectors.toList()));
//        // Map集合循环遍历方式三 推荐，尤其是容量大时
//        System.out.println("第三种：通过Map.entrySet遍历key和value");
//        for (Map.Entry<Integer, List<UserMessage>> m : collect.entrySet()) {
//            // 模板对应可填项Id
//            Integer key = m.getKey();
//            if (key==null||"".equals(key)){
//                List<UserMessage> value = m.getValue();
//            }
//
//
//        }
        List<UserMessage> unique = personList.stream()
                .collect( Collectors.collectingAndThen
                        (Collectors.toCollection(() -> new TreeSet<>
                                ( Comparator.comparing(UserMessage::getId))), ArrayList::new)
                );

        System.out.println();

    }
}
