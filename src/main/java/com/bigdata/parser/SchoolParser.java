package com.bigdata.parser;

import com.bigdata.domain.School;

import java.time.LocalDateTime;
import java.util.Arrays;

public class SchoolParser implements Parser<School>{

    @Override
    public School parse(String str) {
        String[] splitted = str.split(",");
        System.out.println(Arrays.toString(splitted));
        String date = splitted[3];
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        boolean isMainSchool = (splitted[5].equals("본교")) ? true : false;
        return new School(splitted[0], splitted[1], splitted[2], LocalDateTime.of(year, month, day,0, 0, 0), splitted[4], isMainSchool, splitted[6],
                splitted[7], splitted[8], splitted[9], splitted[10], splitted[11], splitted[12], Double.parseDouble(splitted[15]), Double.parseDouble(splitted[16]));
    }
}
