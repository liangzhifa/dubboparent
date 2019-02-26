package com.ts.consumer;

import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.springframework.util.DigestUtils;

public class Md5Test {
    @Test
    public void f(){
        String encode = MD5Encoder.encode("rxctfgvhb".getBytes());
        System.out.println(encode);
        String s = DigestUtils.md5DigestAsHex("123".getBytes());
        System.out.println(s);
    }
}
