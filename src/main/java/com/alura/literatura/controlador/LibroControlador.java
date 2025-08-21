package com.alura.literatura.controlador;

import com.alura.literatura.modelo.Libro;
import com.alura.literatura.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroControlador {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroRepositorio.save(libro);
    }
}

