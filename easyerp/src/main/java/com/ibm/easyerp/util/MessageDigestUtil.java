package com.ibm.easyerp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
public class MessageDigestUtil {
    // MD5加密算法,对密码进行加密
    public static String digestByMD5(String oldstr) {
 
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
 
        byte[] oldbytes = oldstr.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");// 获取对象
            md.update(oldbytes);// 初始化对象
            byte[] newBytes = md.digest();// 运行加密算法
            char[] newStr = new char[32];
            for (int i = 0; i < 16; i++) {
                byte temp = newBytes[i];
                newStr[2 * i] = hexDigits[temp >>> 4 & 0xf];
                newStr[2 * i + 1] = hexDigits[temp & 0xf];
 
            }
            return new String(newStr);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
 
    }
/*    public static void main(String[] args){
        System.out.print(MD5Password("123456"));
        if(MD5Password("123456").equals(MD5Password("123456"))){
            System.out.println("相等");
             
        }
    }*/
}
