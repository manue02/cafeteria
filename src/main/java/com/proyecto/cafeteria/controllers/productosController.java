package com.proyecto.cafeteria.controllers;

import java.util.List;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.cafeteria.models.categoriasModel;
import com.proyecto.cafeteria.models.productosModel;
import com.proyecto.cafeteria.services.categoriasService;
import com.proyecto.cafeteria.services.productosService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/productos")
public class productosController {

    private final productosService productosService;
    private final categoriasService categoriasService;

    public productosController(productosService productosService, categoriasService categoriasService) {
        this.productosService = productosService;
        this.categoriasService = categoriasService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getAllProductos() {
        
        try {

            List<productosModel> productos = productosService.getAllProductos();
            return ResponseEntity.ok(productos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener los productos");
        }
    }

    @PostMapping("añadir/{nombre}/{precio}/{idCategoria}")
    public ResponseEntity<?> addProducto(@PathVariable String nombre, @PathVariable Float precio, @PathVariable Integer idCategoria) {
        
        try {

            Optional <categoriasModel> categoriaEncontrada = categoriasService.findById(idCategoria);

            if (!categoriaEncontrada.isPresent()) {
                return ResponseEntity.badRequest().body("No se ha encontrado la categoría con id: " + idCategoria);
            }else{
                productosModel producto = new productosModel(nombre, precio, true, categoriaEncontrada.get());
                return ResponseEntity.ok(productosService.saveProducto(producto));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al insertar el producto:" + e.getMessage());

        }
    }

    @PutMapping("modificar/{id}{nombre}/{precio}/{idCategoria}")
    public ResponseEntity<?> updateProducto(@PathVariable Integer id,@PathVariable String nombre, @PathVariable Float precio, @PathVariable Integer idCategoria) {
        
        try {

            Optional <categoriasModel> categoriaEncontrada = categoriasService.findById(idCategoria);

            if (!categoriaEncontrada.isPresent()) {
                return ResponseEntity.badRequest().body("No se ha encontrado la categoría con id: " + idCategoria);
            }else{
                
                Optional <productosModel> productoEncontrado = productosService.findById(id);
                
                if (!productoEncontrado.isPresent()) {
                    return ResponseEntity.badRequest().body("No se ha encontrado el producto con id: " + id);
                }else{
                    productosModel productoModificado = productoEncontrado.get();
                    productoModificado.setNombre(nombre);
                    productoModificado.setPrecio(precio);
                    productoModificado.setCategoria(categoriaEncontrada.get());
                    return ResponseEntity.ok(productosService.saveProducto(productoModificado));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al modificar el producto:" + e.getMessage());

        }
    }

    @PutMapping("eliminar/{id}/{activo}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id, @PathVariable Boolean activo) {
        try {
            productosModel producto = productosService.findById(id).orElseThrow(() -> new Exception("Producto no encontrado"));
        
            if (activo == true) {
                producto.setActivo(false);
                return ResponseEntity.ok(productosService.saveProducto(producto));
        }   else {
                producto.setActivo(true);
                return ResponseEntity.ok(productosService.saveProducto(producto));
        }
    }   catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } 
    }

}
