package com.workshop.trabajoclase.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.trabajoclase.domain.Product;

@RestController
@RequestMapping("/api")
public class ProductController {
		//Aquí usas inyecciónes de Dependencias 😁
    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping("/products")
    public List<Product> getProducts(
        @RequestParam(required = false) double minPrice,
        @RequestParam(required = false) double maxPrice,
        @RequestParam(required = false) String category
    ) {
        //Aplica los filtros de minPrice, maxPrice y category, recuerda que pueden aplicarse todos o ninguno
        //List<Product> listadoFiltrado;
        //return listadoFiltrado;
        return null;
    }
}
