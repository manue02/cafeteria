package com.proyecto.cafeteria.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.cafeteria.models.mesasModel;
import com.proyecto.cafeteria.services.mesasService;

@RestController
@RequestMapping("/mesas")
public class mesasController {

    private final mesasService mesasService;

    public mesasController(mesasService mesasService) {
        this.mesasService = mesasService;
    }

    @PutMapping("eliminar/{id}/{activo}")
    public ResponseEntity<?> eliminarMesa(@PathVariable Integer id, @PathVariable Boolean activo) {
       try {
            mesasModel mesa = mesasService.getMesaById(id).orElseThrow(() -> new Exception("Mesa no encontrada"));

            if (activo == true) {
                mesa.setActivo(false);
                return ResponseEntity.ok(mesasService.saveMesa(mesa));
            }   else {
                mesa.setActivo(true);
                return ResponseEntity.ok(mesasService.saveMesa(mesa));
            }
        }   catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: " + e.getMessage());
            } 
    }

}

