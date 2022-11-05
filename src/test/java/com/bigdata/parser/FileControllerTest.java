package com.bigdata.parser;

import com.bigdata.domain.School;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileControllerTest {
    FileController<School> fileController;
    String path;
    List<School> schoolsList;

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
        fileController = new FileController<>(new SchoolParser());
        String filename = "C:\\PJT\\전국초중등학교위치표준데이터.csv";
        String encoding = fileController.findFileEncoding(filename);
        schoolsList = fileController.readLines(filename, encoding);

        assertEquals(23948, schoolsList.size());
    }

    @Test
    @DisplayName("새로운 파일 생성하여 SQL INSERT문 저장하기")
    void createFileAndWriteSqlQueries() throws IOException {
        fileController = new FileController<>(new SchoolParser());
        String path = "C:\\PJT\\전국초중등학교위치표준데이터.csv";
        schoolsList = fileController.readLines(path, "EUC-KR");

        StringBuilder quries = new StringBuilder();
        for (School school : schoolsList) {
            if(quries.length() == 0) {
                quries.append(school.getSqlInsertQuery());
            } else {
                quries.append(school.getTupleString());
            }
        }

        String newFileName = "school_insert.sql";
        fileController.createNewSqlFile(newFileName);
        fileController.writeContents(quries.toString(), newFileName);

        assertEquals(1, new File(newFileName).exists());
    }
}