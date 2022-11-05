package com.bigdata.parser;

import com.bigdata.domain.School;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SchoolParserTest {
    SchoolParser schoolParser;

    @Test
    @DisplayName("원하는 형태로 데이터가 잘 분리되어 배열에 저장되는지 테스트")
    public void splitTest() {
        schoolParser = new SchoolParser();
        String line = "B000003406,대전비래초등학교,초등학교,2005-03-01,공립,본교,운영,대전광역시 대덕구 비래동 245-1,대전광역시 대덕구 우암로492번안길 65,7430000,대전광역시교육청,7441000,대전광역시동부교육지원청,2013-11-29,2021-07-05,36.363531243,127.45289438,2021-09-15,7001220,한국교원대학교";
        School school = schoolParser.parse(line);
        assertEquals("B000003406", school.getId());
        assertEquals("대전비래초등학교", school.getName());
        assertEquals(LocalDateTime.of(2005, 03, 01, 0, 0, 0), school.getAnniversary());
        assertEquals("공립", school.getEstablishForm());
        assertTrue(school.getMainSchool());
        assertEquals("운영", school.getOperationalStatus());
        assertEquals("대전광역시 대덕구 비래동 245-1", school.getJiBunAddress());
        assertEquals("대전광역시 대덕구 우암로492번안길 65", school.getRoadNameAddress());
        assertEquals("7430000", school.getSidoOfficeOfEducationCode());
        assertEquals("대전광역시교육청", school.getSidoOfficeOfEducation());
        assertEquals("7441000", school.getSmallOfficeOfEducationCode());
        assertEquals("대전광역시동부교육지원청", school.getSmallOfficeOfEducation());
        assertEquals(36.363531243, school.getLatitude());
        assertEquals(127.45289438, school.getLongitude());
    }


}