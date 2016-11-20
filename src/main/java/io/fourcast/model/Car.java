package io.fourcast.model;

import java.util.Random;

public class Car {
  public Long id;
  public Brand brand;
  public String model;
  public boolean active;

  public Car() {}

  public Car(Long id, Brand brand, String model) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.active = true;
  }

  public enum Brand {
    BMW, AUDI, MERCEDES
  }
}
