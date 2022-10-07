package com.bigdata.parser;

import com.bigdata.domain.School;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchoolParserTest {
    SchoolParser schoolParser;
    String line1 = "";

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("대용량 데이터 파일을 잘 읽어오는지 테스트")
    void readLinesTest() throws IOException {
        FileController<School> schoolFileController = new FileController<>(new SchoolParser());
        String filename = "C:\\pjt\\전국초중등학교위치표준데이터.csv";
        List<School> schoolsList = schoolFileController.readLines(filename);

        assertEquals(23948, schoolsList.size());
    }
}