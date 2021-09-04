package com.example.kafkademo;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {

        File temp = File.createTempFile("12312222222222222", ".pdf",new File("E://"));

        FileOutputStream fileOutputStream=new FileOutputStream(temp);
        System.out.println("文件路径: "+temp.getAbsolutePath());
        fileOutputStream.flush();
        fileOutputStream.close();


    }
}
