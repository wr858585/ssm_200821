package com.atguigu.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author oono
 * @date 2020 10 31
 */
public class Person {

    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    private Car car;
    private List<String> cities;
    private Map<String,String> map;
    private Properties props;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", car=" + car +
                ", cities=" + cities +
                ", map=" + map +
                ", props=" + props +
                '}';
    }

    public Person(Integer id, String name, Integer age, String phone, Car car, List<String> cities, Map<String, String> map, Properties props) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.car = car;
        this.cities = cities;
        this.map = map;
        this.props = props;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Person(Integer id, String name, Integer age, String phone, Car car, List<String> cities, Map<String, String> map) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.car = car;
        this.cities = cities;
        this.map = map;
    }


    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Person(Integer id, String name, Integer age, String phone, Car car, List<String> cities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.car = car;
        this.cities = cities;
    }

    public Person(Integer id, String name, String phone, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Person(Integer id, String name, Integer age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person(Integer id, String name, Integer age, String phone, Car car) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.car = car;
    }

    public Person() {
    }
}
