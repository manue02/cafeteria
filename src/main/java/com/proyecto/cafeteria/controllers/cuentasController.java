package com.proyecto.cafeteria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.cafeteria.services.cuentasService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/cuentas")
public class cuentasController {

    private final cuentasService cuentasService;

    public cuentasController(cuentasService cuentasService) {
        this.cuentasService = cuentasService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAllCuentas() {
        
        try {

            return ResponseEntity.ok(cuentasService.getAllCuentas());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener las cuentas");
        }
    }

    
    

}
