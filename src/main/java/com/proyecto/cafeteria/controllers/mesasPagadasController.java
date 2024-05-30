package com.proyecto.cafeteria.controllers;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.cafeteria.models.mesasPagadasModel;
import com.proyecto.cafeteria.services.mesasPagadasService;


@RestController
@RequestMapping("/mesasPagadas")
public class mesasPagadasController {

    private final mesasPagadasService mesasPagadasService;

    public mesasPagadasController(mesasPagadasService mesasPagadasService) {
        this.mesasPagadasService = mesasPagadasService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAllMesasPagadas() {
        
        try {

            List<mesasPagadasModel> mesasPagadas = mesasPagadasService.getAllMesasPagadas();
            return ResponseEntity.ok(mesasPagadas);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener las mesas pagadas");
        }
    }

    @GetMapping("/buscar/{fecha}/{hora}")
    public ResponseEntity<?> getFiltroFecha(@PathVariable LocalDate fecha, @PathVariable Time hora) {
        
        try {

            List<mesasPagadasModel> mesasPagadasFiltro = mesasPagadasService.getMesasPagadasByFechaAndHora(fecha, hora);
            return ResponseEntity.ok(mesasPagadasFiltro);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener las mesas pagadas");
        }
    }
    
    @PutMapping("actualizar/{id}/{importe}/{fecha}/{hora}")
    public ResponseEntity<?> updateMesasPagadas(@PathVariable Integer id, @PathVariable Float importe, @PathVariable LocalDate fecha, @PathVariable Time hora) {
        
        try {
            Optional <mesasPagadasModel> mesasPagadas = mesasPagadasService.getMesasPagadasById(id);
            
            if (!mesasPagadas.isPresent()) {
                return ResponseEntity.badRequest().body("La mesa pagada no existe");
            }else{
                mesasPagadasModel mesasPagadasModificada = mesasPagadas.get();
                mesasPagadasModificada.setTasa(importe);
                mesasPagadasModificada.setFecha(fecha);
                mesasPagadasModificada.setHora(hora);
                return ResponseEntity.ok(mesasPagadasService.saveMesaPagada(mesasPagadasModificada));
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar la mesa pagada:" + e.getMessage());
        }
    }


}
