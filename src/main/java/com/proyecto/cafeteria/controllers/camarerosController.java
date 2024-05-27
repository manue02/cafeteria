package com.proyecto.cafeteria.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.cafeteria.models.camarerosModel;
import com.proyecto.cafeteria.services.camarerosService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/camareros")
public class camarerosController {

    private final camarerosService camarerosService;

    public camarerosController(camarerosService camarerosService) {
        this.camarerosService = camarerosService;
    }

    /**
     * Maneja la petición GET para obtener todos los camareros.
     *
     * @return Una ResponseEntity que contiene la lista de camareros si la operación fue exitosa,
     *         o un mensaje de error si ocurrió un error.
     */
    @GetMapping("/todos")
    public ResponseEntity<?> getAllCamareros() {
    
        try {

            List<camarerosModel> camareros = camarerosService.getAllCamareros();
            return ResponseEntity.ok(camareros);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener los camareros");
        }
    }
    

    /**
     * Maneja la petición POST para insertar un nuevo camarero.
     *
     * @param nombre El nombre del camarero a insertar.
     * @return Una ResponseEntity que contiene el camarero insertado si la operación fue exitosa,
     *         o un mensaje de error si ocurrió un error.
     */
    @PostMapping("/insertar/{nombre}")
    public ResponseEntity<?> insertarCamarero(@PathVariable String nombre) {

        try {

            camarerosModel camarero = new camarerosModel(nombre, true);
            return ResponseEntity.ok(camarerosService.saveCamarero(camarero));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al insertar el camarero:" + e.getMessage());
        }
    }

    /**
     * Maneja la petición GET para buscar un camarero por su ID.
     *
     * @param id El ID del camarero a buscar.
     * @return Una ResponseEntity que contiene el camarero encontrado si la operación fue exitosa,
     *         o un mensaje de error si ocurrió un error.
     */
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarCamarero(@PathVariable Integer id) {

        try {

            return ResponseEntity.ok(camarerosService.findById(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al buscar el camarero:" + e.getMessage());
        }
    }

    /**
     * Maneja la petición PUT para cambiar el estado de un camarero.
     *
     * @param id El ID del camarero a cambiar.
     * @param activo El nuevo estado del camarero.
     * @return Una ResponseEntity que contiene el camarero con el estado cambiado si la operación fue exitosa,
     *         o un mensaje de error si ocurrió un error.
     */
    @PutMapping("eliminar/{id}/{activo}")
    public ResponseEntity<?> eliminarCamarero(@PathVariable Integer id, @PathVariable Boolean activo) {
        
    try {
        // Buscar el camarero por ID y lanzar una excepción si no se encuentra el camarero con la función orElseThrow 
        // que llama a la función anónima que lanza la excepción.
        camarerosModel camarero = camarerosService.findById(id).orElseThrow(() -> new Exception("Camarero no encontrado"));

        if (activo == true) {
            camarero.setActivo(false);
            return ResponseEntity.ok(camarerosService.saveCamarero(camarero));
        } else {
            camarero.setActivo(true);
            return ResponseEntity.ok(camarerosService.saveCamarero(camarero));
        }
    }   catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
        
    }

    /**
     * Maneja la petición PUT para cambiar el nombre de un camarero.
     *
     * @param id El ID del camarero a cambiar.
     * @param nombre El nuevo nombre del camarero.
     * @return Una ResponseEntity que contiene el camarero con el nombre cambiado si la operación fue exitosa,
     *         o un mensaje de error si ocurrió un error.
     */
    @PutMapping("actualizar/{id}/{nombre}")
    public ResponseEntity<?> actualizarCamarero(@PathVariable Integer id, @PathVariable String nombre) {
        
        try {
            camarerosModel camarero = camarerosService.findById(id).orElseThrow(() -> new Exception("Camarero no encontrado"));
            camarero.setNombre(nombre);
            return ResponseEntity.ok(camarerosService.saveCamarero(camarero));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
    
}
