package com.example.springboot.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@Service
public class UtilService {
    public static String createRandomCode(int codeLength){
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < codeLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        System.out.println(output);
        return output ;
    }

    public static int compareDates(Date d1, Date d2) {
        try {

            int year1 = d1.getYear();
            int year2 = d2.getYear();

            int month1 = d1.getMonth();
            int month2 = d2.getMonth();

            int day1 = d1.getDay();
            int day2 = d2.getDay();

            if (year1 > year2) return 1;
            if (month1 > month2) return 1;
            if (day1 > day2) return 1;

            if (year1 == year2 && month1 == month2 && day1 == day2) return 0;
            return -1;
        } catch (Exception ex) {
            return 9999;
        }
    }
}
