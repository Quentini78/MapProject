package com.example.City.Service;

import com.example.City.Connexion;
import com.example.City.Entity.City;
import com.example.City.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final Connexion connexion;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.connexion = new Connexion();
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        connexion.connect();
        ResultSet resultSet = connexion.queryAll("SELECT * FROM CITY");
        List<City> cities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setLatitude(resultSet.getDouble("latitude"));
                city.setLongitude(resultSet.getDouble("longitude"));
                city.setRegion(resultSet.getString("region"));
                city.setPopulation(resultSet.getInt("population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connexion.close();

        return cities;//(List<City>) cityRepository.findAll();
    }

    public City findCity(String name) {
        connexion.connect();
        ResultSet resultSet = connexion.queryOneCity("SELECT * FROM CITY Where name=?", name);
        City city = new City();
        try {
            while (resultSet.next()) {
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setLatitude(resultSet.getDouble("latitude"));
                city.setLongitude(resultSet.getDouble("longitude"));
                city.setRegion(resultSet.getString("region"));
                city.setPopulation(resultSet.getInt("population"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connexion.close();
        return city;
    }
}
