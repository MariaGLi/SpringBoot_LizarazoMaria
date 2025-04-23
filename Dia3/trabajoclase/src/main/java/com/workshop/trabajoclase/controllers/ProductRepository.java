package com.workshop.trabajoclase.controllers;

import com.workshop.trabajoclase.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRepository {
    
    @GetMapping("/search")
    public Map<String, Object> producticos(
        @RequestParam(defaultValue = "0") double produc) {
        List<Product> productos = new ArrayList<>(
            List.of(new Product(1, "Mouse", "Ordenadores", 50590.22, 27))
            );
        productos.add(new Product(2, "Laptop", "Ordenadores", 5047590.22, 0));
        productos.add(new Product(3, "Desktop", "Ordenadores", 50590.22, 7));
        productos.add(new Product(4, "Netbooks", "Ordenadores", 5046590.22, 0));
        productos.add(new Product(5, "Tabletas", "Ordenadores", 5039590.22, 10));
        productos.add(new Product(6, "Disco duro", "Ordenadores", 580590.22, 0));
        productos.add(new Product(7, "Placa base", "Ordenadores", 590590.22, 6));
        productos.add(new Product(8, "Memoria RAM", "Ordenadores", 50590.22, 10));
        productos.add(new Product(9, "Tarjeta gráfica", "Ordenadores", 50590.22, 8));
        productos.add(new Product(10, "Teclado", "Ordenadores", 50590.22, 0));
        productos.add(new Product(11, "Memoria USB", "Ordenadores", 50590.22, 30));
        productos.add(new Product(12, "Servidores", "Ordenadores", 5210590.22, 0));
        productos.add(new Product(13, "Minicomputer", "Ordenadores", 5503590.22, 5));
        productos.add(new Product(14, "Procesador", "Ordenadores", 5190590.22, 4));
        productos.add(new Product(15, "Pantalla", "Ordenadores", 50590.22, 10));
        productos.add(new Product(16, "Cables", "Cableado", 59590.22, 27));
        productos.add(new Product(17, "RJ45", "Cableado", 50590.22, 30));
        productos.add(new Product(18, "HDMI", "Cableado", 50590.22, 20));
        productos.add(new Product(19, "VGA", "Cableado", 50590.22, 17));
        productos.add(new Product(20, "Adaptador", "Cableado", 50590.22, 15));
        
        return Map.of("Productos", productos);
    }
    
}
