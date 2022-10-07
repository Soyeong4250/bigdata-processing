package com.bigdata.parser;

import com.bigdata.domain.School;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileControllerTest {
    FileController<School> fileController;
    String path;


    @Test
    @DisplayName("인코딩 확인 테스트")
    void findFlieEncoding() throws IOException {
        path = "C:\\pjt\\전국초중등학교위치표준데이터.csv";
        fileController = new FileController(new SchoolParser());

        String encoding = fileController.findFileEncoding(path);
        System.out.println(encoding);  // 현재 파일 인코딩이 무엇인지 출력해보기
        assertNotEquals("UTF-8", encoding);
    }

}