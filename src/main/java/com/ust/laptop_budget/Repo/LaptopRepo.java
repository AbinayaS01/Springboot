package com.ust.laptop_budget.Repo;

import com.ust.laptop_budget.Model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop,Integer> {
}
