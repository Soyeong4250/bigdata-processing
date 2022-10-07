package com.bigdata.parser;

import com.bigdata.domain.School;

public interface Parser<T> {
    T parse(String str);
}
