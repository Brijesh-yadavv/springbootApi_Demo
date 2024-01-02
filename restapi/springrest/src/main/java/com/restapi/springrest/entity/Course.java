package com.restapi.springrest.entity;

public class Course {
    private long id;
    private String title;
    private String desc;

    public Course() {
        super();
    }

    public Course(long id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + ", desc=" + desc + "]";
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
