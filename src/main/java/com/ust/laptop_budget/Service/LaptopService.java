package com.ust.laptop_budget.Service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.laptop_budget.Model.Laptop;
import com.ust.laptop_budget.Repo.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service // Add this annotation
public class LaptopService {
    @Autowired
    private LaptopRepo laptopRepo;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public LaptopService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public List<Laptop> saveLaptop(List<Laptop> laptops) {
        return laptopRepo.saveAll(laptops);
    }

    public Map<String, List<Laptop>> groupByLaptopByBrand() {
        return jpaStreamer.stream(Laptop.class).collect(Collectors.groupingBy(Laptop::getBrand));
    }

    public List<Laptop> groupByProcessor() {
        return laptopRepo.findAll();
    }

    public Map<String, Long> groupLaptopByBudgetUnderProcessor(int budget) {
        return jpaStreamer.stream(Laptop.class).filter(laptop -> laptop.getBudget() <= budget)
                .collect(Collectors.groupingBy(Laptop::getProcessor, Collectors.counting()));
    }

    public Map<String, Long> countLaptopByOS() {
        return jpaStreamer.stream(Laptop.class).collect(Collectors.groupingBy(Laptop::getOs, Collectors.counting()));
    }
}
