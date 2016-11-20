package io.fourcast.endpoint;

import com.google.api.server.spi.config.*;
import io.fourcast.model.Car;
import io.fourcast.service.CarService;

import java.util.Collection;

import static com.google.api.server.spi.config.ApiMethod.HttpMethod.*;

@Api(
  description = "Endpoint to handle CRUD operations on Car objects",
  name = "carEndpoint"
)
public class CarEndpoint {

  //Handles CRUD operations on Cars
  private CarService carService = new CarService();

  @ApiMethod(name = "list", path = "car", httpMethod = GET)
  public Collection<Car> list() {
    return carService.list();
  }

  @ApiMethod(name = "getCarById", path = "car/{id}", httpMethod = GET)
  public Car getCarById(@Named("id") long id) {
    return carService.get(id);
  }

  @ApiMethod(name = "save", path = "car", httpMethod = POST)
  public Car save(Car car) {
    return carService.save(car);
  }

  @ApiMethod(name = "update", path = "car", httpMethod = PUT)
  public Car update(Car car) {
    return carService.update(car);
  }

  @ApiMethod(name = "deactivate", path = "deactivate", httpMethod = PUT)
  public void deactivate(Car car) {
    carService.deactivate(car);
  }

  @ApiMethod(name = "remove", path = "car/{id}", httpMethod = DELETE)
  public void remove(@Named("id") int id) {
    carService.remove(id);
  }
}
