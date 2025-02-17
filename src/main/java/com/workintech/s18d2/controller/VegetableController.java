package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
@RequiredArgsConstructor
public class VegetableController {

    // Dependency Injection of VegetableService using Lombok's @RequiredArgsConstructor
    private final VegetableService vegetableService;

    /**
     * GET /vegetables
     * Returns all vegetables sorted by price in ascending order.
     */
    @GetMapping
    public ResponseEntity<?> getVegetables() {
        List<Vegetable> vegetables = vegetableService.getByPriceAsc();
        return ResponseEntity.ok(new ApiResponse(true, "Vegetables retrieved in ascending order", vegetables));
    }

    /**
     * GET /vegetables/desc
     * Returns all vegetables sorted by price in descending order.
     */
    @GetMapping("/desc")
    public ResponseEntity<?> getVegetablesDesc() {
        List<Vegetable> vegetables = vegetableService.getByPriceDesc();
        return ResponseEntity.ok(new ApiResponse(true, "Vegetables retrieved in descending order", vegetables));
    }

    /**
     * GET /vegetables/{id}
     * Returns the vegetable with the specified id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getVegetableById(@PathVariable Long id) {
        Vegetable vegetable = vegetableService.getById(id);
        return ResponseEntity.ok(new ApiResponse(true, "Vegetable retrieved", vegetable));
    }

    /**
     * POST /vegetables
     * Saves a new vegetable or updates an existing one based on the provided JSON body.
     */
    @PostMapping
    public ResponseEntity<?> saveVegetable(@RequestBody Vegetable vegetable) {
        Vegetable savedVegetable = vegetableService.save(vegetable);
        return ResponseEntity.ok(new ApiResponse(true, "Vegetable saved/updated", savedVegetable));
    }

    /**
     * POST /vegetables/{name}
     * Searches and returns all vegetables whose name contains the given substring.
     */
    @PostMapping("/{name}")
    public ResponseEntity<?> searchVegetables(@PathVariable String name) {
        List<Vegetable> vegetables = vegetableService.searchByName(name);
        return ResponseEntity.ok(new ApiResponse(true, "Vegetables retrieved", vegetables));
    }

    /**
     * DELETE /vegetables/{id}
     * Deletes the vegetable with the specified id and returns the deleted vegetable.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVegetable(@PathVariable Long id) {
        Vegetable deletedVegetable = vegetableService.delete(id);
        return ResponseEntity.ok(new ApiResponse(true, "Vegetable deleted", deletedVegetable));
    }
}
