package com.henry.spring.service.impl;

import com.henry.spring.service.MyCar;

/**
 * @author heyong
 * @date 2020/11/12 15:44
 */
public class Bc extends MyCar {

  private int price;

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Bc{" +
            "price=" + price +
            '}';
  }
}
