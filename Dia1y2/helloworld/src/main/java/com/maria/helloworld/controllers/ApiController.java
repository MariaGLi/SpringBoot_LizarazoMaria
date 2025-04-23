package com.maria.helloworld.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.maria.helloworld.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ApiController {

    @GetMapping("/")
    public String home() {
        return "Hola gente!";
    }

    @GetMapping("/saludo") // /saludo?nombre=Maria
    public String saludo(
            @RequestParam(name = "Nombre", required = true) String name,
            @RequestParam(name = "apellido", required = true, defaultValue = "Apellido común") String lastname) {
        return "Bienvenida " + name + " " + lastname;
    }

    @GetMapping("/search")
    public Map<String, String> buscar(
            @RequestParam(name = "nombre", defaultValue = "Apellido común") String name) {
        Map<String, String> cities = new HashMap<>();
        cities.put("TIB", "Tibú");
        cities.put("NYC", "New York");
        cities.put("BOG", "Bogotá");
        cities.put("NVA", "Neiva");
        cities.put("LET", "Leticia");
        cities.put("PER", "Pereira");
        if (cities.containsKey(name)) {
            return Map.of(name, cities.get(name));
        } else {
            return cities;
        }
    }

    @GetMapping("/tax")
    public Map<String, Object> calcular(
        @RequestParam(defaultValue = "0") double impuestos) {
        List<Producto> productos = new ArrayList<>(
            List.of(new Producto(1, "Pan", 2000))
            );
        productos.add(new Producto(2, "Gaseosa", 3500));
        productos.add(new Producto(3, "Salchichón", 1500));

        double precios = productos.stream().map(producto -> producto.getPrice()).reduce(0.0, (precioA, precioB) -> precioA + precioB);
        return Map.of("productos", productos,"total", (precios + (precios * (impuestos / 100))), "valor_neto", precios, "IVA",  impuestos+"%");

        /*double total = 0;
        double valor_neto = 0;

        for(Producto p : productos){
            total += p.getPrice();
        }

        impuestos = impuestos/100;
        valor_neto = impuestos * total + total;


        return Map.of("productos", productos, "total con IVA", valor_neto, "valor_neto", total); */      
    }
}
