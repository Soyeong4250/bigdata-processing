package com.bigdata.parser;

import com.bigdata.domain.School;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileControllerTest {
    FileController<School> fileController;
    String path;


    @Test
    @Order(1)
    @DisplayName("인코딩 확인 테스트")
    void findFlieEncoding() throws IOException {
        path = "C:\\PJT\\전국초중등학교위치표준데이터.csv";
        fileController = new FileController(new SchoolParser());

        String encoding = fileController.findFileEncoding(path);
        System.out.println(encoding);  // 현재 파일 인코딩이 무엇인지 출력해보기
        assertNotEquals("UTF-8", encoding);
    }

    @Test
    @Order(2)
    @DisplayName("대용량 데이터 파일을 잘 읽어오는지 테스트")
    void readLinesTest() throws IOException {
        FileController<School> schoolFileController = new FileController<>(new SchoolParser());
        String filename = "C:\\PJT\\전국초중등학교위치표준데이터.csv";
        String encoding = schoolFileController.findFileEncoding(filename);
        List<School> schoolsList = schoolFileController.readLines(filename, encoding);

        assertEquals(23948, schoolsList.size());
    }
}