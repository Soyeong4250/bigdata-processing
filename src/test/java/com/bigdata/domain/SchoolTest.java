package com.bigdata.domain;

import com.bigdata.parser.Parser;
import com.bigdata.parser.SchoolParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    @Test
    @DisplayName("SQL INSERT문이 잘 작성되는지 확인")
    public void makeSqlInsertTest() {
        Parser<School> schoolParser = new SchoolParser();
        String line1 = "B000003406,대전비래초등학교,초등학교,2005-03-01,공립,본교,운영,대전광역시 대덕구 비래동 245-1,대전광역시 대덕구 우암로492번안길 65,7430000,대전광역시교육청,7441000,대전광역시동부교육지원청,2013-11-29,2021-07-05,36.363531243,127.45289438,2021-09-15,7001220,한국교원대학교";
        String line2 = "B000004955,북삼초등학교,초등학교,1946-01-24,공립,본교,운영,강원도 동해시 지흥동 124-1,강원도 동해시 지양길 77,7800000,강원도교육청,7841000,강원도동해교육지원청,2013-11-29,2021-09-30,37.4956557859,129.1009681324,2022-03-24,C738100,청주대학교 지방교육재정연구원";
        School school1 = schoolParser.parse(line1);
        StringBuilder sql = new StringBuilder();
        sql.append(school1.getSqlInsertQuery());
        sql.append(",\n");
        School school2 = schoolParser.parse(line2);
        sql.append(school2.getTupleString());
        String result = "INSERT INTO `test-db`.`nation_wide_school`\n" +
                "VALUES\n" +
                "(\"B000003406\", \"대전비래초등학교\", \"초등학교\", \"2005-03-01T00:00\", \"공립\", \"true\", \"운영\", \"대전광역시 대덕구 비래동 245-1\",\n" +
                "\"대전광역시 대덕구 우암로492번안길 65\", \"7430000\", \"대전광역시교육청\", \"7441000\", \"대전광역시동부교육지원청\", \"36.363531243\", \"127.45289438\"),\n" +
                "(\"B000004955\", \"북삼초등학교\", \"초등학교\", \"1946-01-24T00:00\", \"공립\", \"true\", \"운영\", \"강원도 동해시 지흥동 124-1\",\n" +
                "\"강원도 동해시 지양길 77\", \"7800000\", \"강원도교육청\", \"7841000\", \"강원도동해교육지원청\", \"37.4956557859\", \"129.1009681324\")";
        assertEquals(result, sql.toString());
    }
}