package com.bigdata.parser;

import com.bigdata.domain.School;

public interface Parser {
    School parse(String str);
}
