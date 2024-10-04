package com.ust.laptop_budget.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="laptop_details")

public class Laptop {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="Brand")
    private String brand;

    @Column(name="Processor")
    private String processor;

    @Column(name="Ram")
    private String ram;

    @Column(name="Display")
    private String display;

    @Column(name="Battery")
    private String Battery;

    @Column(name="OS")
    private String Os;

    @Column(name="Budget")
    private int Budget;
}
