package com.proyecto.cafeteria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.cafeteria.models.categoriasModel;
import com.proyecto.cafeteria.services.categoriasService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/categorias")
public class categoriasController {

    private final categoriasService categoriasService;

    public categoriasController(categoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }


    @GetMapping("/todos")
    public ResponseEntity<?> getAllCategorias() {
       
        try {

            List<categoriasModel> categorias = categoriasService.findAll();
            return ResponseEntity.ok(categorias);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener las categorias");
        }
    }

    @PostMapping("/insertar/{nombre}")
    public ResponseEntity<?> insertarCategoria(@PathVariable String nombre) {

        try {

            categoriasModel categoria = new categoriasModel(nombre, true);
            return ResponseEntity.ok(categoriasService.saveCategoria(categoria));


        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al insertar la categoria:" + e.getMessage());

        }
        
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> getCategoriaById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(categoriasService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener la categoria");
        }
    }

    @PutMapping("eliminar/{id}/{activo}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Integer id, @PathVariable Boolean activo) {
        try {
            categoriasModel categoria = categoriasService.findById(id).orElseThrow(() -> new Exception("Categoria no encontrada"));
        
            if (activo == true) {
                categoria.setActivo(false);
                return ResponseEntity.ok(categoriasService.saveCategoria(categoria));
        }   else {
                categoria.setActivo(true);
                return ResponseEntity.ok(categoriasService.saveCategoria(categoria));
        }
    }   catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } 
    }

    
    

}
