package com.atguigu.pojo;

/**
 * @author oono
 * @date 2020 11 02
 */
public class Car {

    private String carNo;
    private String carType;

    @Override
    public String toString() {
        return "Car{" +
                "carNo='" + carNo + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Car(String carNo, String carType) {
        this.carNo = carNo;
        this.carType = carType;
    }

    public Car() {
    }
}
