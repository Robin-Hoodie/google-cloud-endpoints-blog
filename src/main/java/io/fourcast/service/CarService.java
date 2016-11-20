package io.fourcast.service;

import com.google.api.server.spi.response.NotFoundException;
import io.fourcast.model.Car;

import java.util.*;

import static io.fourcast.model.Car.Brand.AUDI;
import static io.fourcast.model.Car.Brand.BMW;
import static io.fourcast.model.Car.Brand.MERCEDES;

public class CarService {

  private Map<Long, Car> cars;

  public CarService() {
    cars = new HashMap<>();
    initializeCars();
  }

  private void initializeCars() {
    cars.put(1L, new Car(1L, AUDI, "S7"));
    cars.put(2L, new Car(2L, AUDI, "RS6"));
    cars.put(3L, new Car(3L, AUDI, "R8"));
    cars.put(4L, new Car(4L, BMW, "M6"));
    cars.put(5L, new Car(5L, BMW, "i8"));
    cars.put(6L, new Car(6L, BMW, "X6M"));
    cars.put(7L, new Car(7L, MERCEDES, "S500"));
    cars.put(8L, new Car(8L, MERCEDES, "AMG S63"));
    cars.put(9L, new Car(9L, MERCEDES, "AMG GLE63"));
  }

  public Car get(long id) {
    return cars.get(id);
  }

  public Car save(Car car) {
    return cars.put(car.id, car);
  }

  public Car update(Car car) {
    return cars.put(car.id, car);
  }

  public Collection<Car> list() {
    List<Car> activeCars = new ArrayList<>();
    for(Car car: cars.values()) {
      if (car.active) {
        activeCars.add(car);
      }
    }
    return activeCars;
  }

  public void remove(long id) {
    cars.remove(id);
  }

  public void deactivate(Car car) {
    if (car.id == null) {
      throw new IllegalArgumentException("Can not deactivate a car that didn't even exist yet!");
    }
    car.active = false;
    cars.put(car.id, car); //No need to return a deactivated Car
  }

}