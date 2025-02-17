package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    @Override
    public Vegetable getById(Long id) {
        if (id < 0)
            throw new PlantException("ID cannot be negative");
        return vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable not found with id: " + id));
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        // Optionally add validations here
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = getById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }
}
