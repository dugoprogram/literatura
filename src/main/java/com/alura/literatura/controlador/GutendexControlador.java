package com.alura.literatura.controlador;

import com.alura.literatura.modelo.Libro;
import com.alura.literatura.servicio.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/gutendex")
public class GutendexControlador {

    @Autowired
    private GutendexService gutendexService;

    @GetMapping("/buscar")
    public List<Libro> buscarLibros(@RequestParam String titulo) throws IOException, InterruptedException {
        return gutendexService.buscarLibrosPorTitulo(titulo);
    }
}
