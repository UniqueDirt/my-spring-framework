package com.henry.stu.pojo;

/**
 * @author heyong
 * @date 2020/8/28 15:05
 */
public class Car {

  private String brand;

  private int maxSpeed;

  private double price;

  private String name;

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Car{" +
            "brand='" + brand + '\'' +
            ", maxSpeed=" + maxSpeed +
            ", price=" + price +
            '}';
  }
}
