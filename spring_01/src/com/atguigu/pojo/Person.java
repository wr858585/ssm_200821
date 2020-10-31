package com.atguigu.pojo;

/**
 * @author oono
 * @date 2020 10 31
 */
public class Person {

    private Integer id;
    private String name;
    private Integer age;
    private String phone;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person() {
        System.out.println("调用的是无参构造器");
    }

    public Person(Integer id, String name, Integer age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        System.out.println("调用的是有参构造器");
    }

    public Person(Integer id, String name, String phone, Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        System.out.println("用的第二个重载构造器");
    }
}
