package com.bigdata.parser;

import com.bigdata.domain.School;

public class SchoolParser implements Parser<School>{

    @Override
    public School parse(String str) {
        System.out.println(str);

        return new School();
    }
}
