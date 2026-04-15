package proyecto.full.stack.en.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyecto.full.stack.en.spring.boot.model.Libro;
import proyecto.full.stack.en.spring.boot.service.LibroService;

@RestController
@RequestMapping("/api/libros")

public class LibroController {

    @Autowired
    private LibroService service;

    @GetMapping
    public List<Libro> listar() { return service.listarTodo(); }

    @PostMapping
    public void guardar(@RequestBody Libro l) { service.agregar(l); }

    @GetMapping("/autor/{nombre}")
    public List<Libro> filtrar(@PathVariable String nombre) { 
        return service.buscarPorAutor(nombre); 
    }
}
