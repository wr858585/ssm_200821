package com.atguigu.pojo;

/**
 * @author oono
 * @date 2020 11 06
 */
public class Car {

    private String carNo;
    private String name;

    @Override
    public String toString() {
        return "Car{" +
                "carNo='" + carNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(String carNo, String name) {
        this.carNo = carNo;
        this.name = name;
    }

    public Car() {
    }
}
