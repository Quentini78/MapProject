package com.example.City.Router;

import com.example.City.Entity.City;
import com.example.City.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cities")
public class CityRouter {
    @Autowired
    private CityService cityService;

    /**
     * Recupere toutes les villes presentent dans la bc city.db
     */
    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        return ResponseEntity.ok(cityService.findAll());
    }

    /**
     *Recupere les donnees de la ville mise dans l'URL
     */
    @GetMapping("/{name}")
    public ResponseEntity<City> getCity(@PathVariable String name) {
        return ResponseEntity.ok(cityService.findCity(name));
    }

}
