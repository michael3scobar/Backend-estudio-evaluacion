package proyecto.full.stack.en.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.full.stack.en.spring.boot.model.Libro;
import proyecto.full.stack.en.spring.boot.repository.LibroRepository;

@Service

public class LibroService {

    @Autowired
    private LibroRepository repo;

    public List<Libro> listarTodo() { return repo.obtenerTodos(); }
    public void agregar(Libro l) { repo.guardar(l); }

    // Filtro por autor usando Streams (Muy importante para la nota)
    public List<Libro> buscarPorAutor(String autor) {
        return repo.obtenerTodos().stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .toList();
    }
    

}
