package com.atguigu.pojo;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 29
 */
public class Clazz {

    private Integer id;
    private String name;
    private List<Student> students;

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Clazz(Integer id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Clazz() {
    }
}
