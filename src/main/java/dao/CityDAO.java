package dao;

import model.City;

import java.util.List;

public interface CityDAO {
    void create(City city);

    City findById(int id);

    List<City> findAll();

    void update(City city);

    void delete(City city);
}
