package com.henry.stu.pojo;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author heyong
 * @date 2020/8/28 15:05
 */
public class CarFactoryBean implements FactoryBean<Car> {

  private String carInfo;

  public Car getObject() throws Exception {
    Car car = new Car();
    String[] info = carInfo.split(",");
    car.setBrand(info[0].trim());
    car.setMaxSpeed(Integer.valueOf(info[1].trim()));
    car.setPrice(Double.valueOf(info[2].trim()));
    return car;
  }

  public boolean isSingleton() {
    return false;
  }

  public Class<?> getObjectType() {
    return Car.class;
  }

  public void setCarInfo(String carInfo) {
    this.carInfo = carInfo;
  }

  public String getCarInfo() {
    return this.carInfo;
  }

  public CarFactoryBean(String carInfo) {
    this.carInfo = carInfo;
  }

  @Override
  public String toString() {
    return "CarFactoryBean{" +
            "carInfo='" + carInfo + '\'' +
            '}';
  }
}
