package com.yedam.myserver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {
   
   @Test
   public void test() {
      // Create an encoder with strength 16
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4); // 암호화 강도? 암호화 지연시간?
      String result = encoder.encode("1111");
      System.out.println(result);
      assertTrue(encoder.matches("1234", result));
      
   }

}