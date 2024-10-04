package com.ust.laptop_budget.Controller;

import com.ust.laptop_budget.Model.Laptop;
import com.ust.laptop_budget.Service.LaptopService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @PostMapping("/save")
    @Operation(summary = "Save laptops")
    public List<Laptop> saveLaptop(@RequestBody List<Laptop> laptops) {
        return laptopService.saveLaptop(laptops);
    }

    @GetMapping("/groupByBrand")
    @Operation(summary = "Group laptops by brand")
    public Map<String, List<Laptop>> groupByLaptopByBrand() {
        return laptopService.groupByLaptopByBrand();
    }

    @GetMapping("/findAll")
    @Operation(summary = "Get all laptops")
    public List<Laptop> findAllLaptops() {
        return laptopService.groupByProcessor();
    }

    @GetMapping("/groupingByProcessor/budget/{tier}")
    @Operation(summary = "Group laptops by budget under processor")
    public Map<String, Long> groupLaptopByBudgetUnderProcessor(@PathVariable("tier") int budget) {
        return laptopService.groupLaptopByBudgetUnderProcessor(budget);
    }


    @GetMapping("/countByOS")
    @Operation(summary = "Count laptops by OS")
    public Map<String, Long> countLaptopByOS() {
        return laptopService.countLaptopByOS();
    }
}
