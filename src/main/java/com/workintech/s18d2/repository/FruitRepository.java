package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();

    // Using Spring Data JPA query derivation for names that contain a substring.
    List<Fruit> searchByName(String name);
}
