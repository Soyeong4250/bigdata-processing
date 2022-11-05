package com.bigdata.domain;

import java.time.LocalDateTime;

public class School {
    private String id;
    private String name;
    private String grade;
    private String anniversary;
    private LocalDateTime establishForm;
    private String mainSchool;
    private String jiBunAddress;
    private String roadNameAddress;
    private String sidoOfficeOfEducationCode;
    private String sidoOfficeOfEducation;
    private String smallOfficeOfEducationCode;
    private String smallOfficeOfEducation;
    private Float latitude;  // 위도
    private Float longitude;  // 경도

    public School() {
    }

    public School(String id, String name, String grade, String anniversary, LocalDateTime establishForm, String mainSchool, String jiBunAddress, String roadNameAddress, String sidoOfficeOfEducationCode, String sidoOfficeOfEducation, String smallOfficeOfEducationCode, String smallOfficeOfEducation, Float latitude, Float longitude) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.anniversary = anniversary;
        this.establishForm = establishForm;
        this.mainSchool = mainSchool;
        this.jiBunAddress = jiBunAddress;
        this.roadNameAddress = roadNameAddress;
        this.sidoOfficeOfEducationCode = sidoOfficeOfEducationCode;
        this.sidoOfficeOfEducation = sidoOfficeOfEducation;
        this.smallOfficeOfEducationCode = smallOfficeOfEducationCode;
        this.smallOfficeOfEducation = smallOfficeOfEducation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public LocalDateTime getEstablishForm() {
        return establishForm;
    }

    public String getMainSchool() {
        return mainSchool;
    }

    public String getJiBunAddress() {
        return jiBunAddress;
    }

    public String getRoadNameAddress() {
        return roadNameAddress;
    }

    public String getSidoOfficeOfEducationCode() {
        return sidoOfficeOfEducationCode;
    }

    public String getSidoOfficeOfEducation() {
        return sidoOfficeOfEducation;
    }

    public String getSmallOfficeOfEducationCode() {
        return smallOfficeOfEducationCode;
    }

    public String getGetSmallOfficeOfEducation() {
        return smallOfficeOfEducation;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public String getSqlInsertQuery() {
        String sql = String.format("INSERT INTO `test-db`.`nation_wide_school`\n" +
                "VALUES\n" +
                "(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\",\n" +
                "\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\"",
                this.id, this.name, this.grade, this.anniversary, this.establishForm, this.mainSchool, this.jiBunAddress,
                this.roadNameAddress, this.sidoOfficeOfEducationCode, this.sidoOfficeOfEducation, this.sidoOfficeOfEducationCode, this.smallOfficeOfEducation, this.latitude, this.longitude);
        return sql;
    }
}
