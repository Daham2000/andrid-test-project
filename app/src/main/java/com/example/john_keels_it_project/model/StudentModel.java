package com.example.john_keels_it_project.model;

public class StudentModel {
    private String stuId;
    private String stuName;
    private String stuAge;
    private String stuCourseName;

    public StudentModel() {
    }

    public StudentModel(String stuId, String stuName, String stuAge, String stuCourseName) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuCourseName = stuCourseName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuCourseName() {
        return stuCourseName;
    }

    public void setStuCourseName(String stuCourseName) {
        this.stuCourseName = stuCourseName;
    }
}
