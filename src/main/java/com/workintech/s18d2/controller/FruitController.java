package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
@RequiredArgsConstructor
public class FruitController {

    private final FruitService fruitService;

    /**
     * GET /fruit
     * Returns all fruits sorted by price in ascending order.
     */
    @GetMapping
    public ResponseEntity<List<Fruit>> getFruits() {
        List<Fruit> fruits = fruitService.getByPriceAsc();
        return ResponseEntity.ok(fruits);
    }

    /**
     * GET /fruit/desc
     * Returns all fruits sorted by price in descending order.
     */
    @GetMapping("/desc")
    public ResponseEntity<List<Fruit>> getFruitsDesc() {
        List<Fruit> fruits = fruitService.getByPriceDesc();
        return ResponseEntity.ok(fruits);
    }

    /**
     * GET /fruit/{id}
     * Returns the fruit with the specified id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id) {
        Fruit fruit = fruitService.getById(id);
        return ResponseEntity.ok(fruit);
    }

    /**
     * POST /fruit
     * Saves a new fruit or updates an existing one based on the provided JSON body.
     */
    @PostMapping
    public ResponseEntity<Fruit> saveFruit(@RequestBody Fruit fruit) {
        Fruit savedFruit = fruitService.save(fruit);
        return ResponseEntity.ok(savedFruit);
    }

    /**
     * GET /fruit/name/{name}
     * Searches and returns all fruits whose name contains the given substring.
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Fruit>> searchFruits(@PathVariable String name) {
        List<Fruit> fruits = fruitService.searchByName(name);
        return ResponseEntity.ok(fruits);
    }

    /**
     * DELETE /fruit/{id}
     * Deletes the fruit with the specified id and returns the deleted fruit.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable Long id) {
        Fruit deletedFruit = fruitService.delete(id);
        return ResponseEntity.ok(deletedFruit);
    }
}
