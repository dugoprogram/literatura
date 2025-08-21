package com.alura.literatura;

import com.alura.literatura.modelo.Autor;
import com.alura.literatura.modelo.Libro;
import com.alura.literatura.repositorio.AutorRepositorio;
import com.alura.literatura.repositorio.LibroRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class LiteraturaApp implements CommandLineRunner {

    private final LibroRepositorio libroRepositorio;
    private final AutorRepositorio autorRepositorio;

    public LiteraturaApp(LibroRepositorio libroRepositorio, AutorRepositorio autorRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== Menú LiterAlura ===");
            System.out.println("1. Listar todos los libros");
            System.out.println("2. Listar todos los autores");
            System.out.println("3. Listar autores vivos en un año");
            System.out.println("4. Listar libros por idioma");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> listarLibros();
                case 2 -> listarAutores();
                case 3 -> {
                    System.out.print("Ingresa el año: ");
                    int anio = sc.nextInt();
                    sc.nextLine();
                    listarAutoresVivos(anio);
                }
                case 4 -> {
                    System.out.print("Ingresa el idioma (ej: 'es', 'en'): ");
                    String idioma = sc.nextLine();
                    listarLibrosPorIdioma(idioma);
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void listarLibros() {
        List<Libro> libros = libroRepositorio.findAll();
        libros.forEach(System.out::println);
    }

    private void listarAutores() {
        List<Autor> autores = autorRepositorio.findAll();
        autores.forEach(System.out::println);
    }

    private void listarAutoresVivos(int anio) {
        List<Autor> autores = autorRepositorio.findByFechaFallecimientoIsNullOrFechaFallecimientoGreaterThanEqual(anio);
        autores.forEach(System.out::println);
    }

    private void listarLibrosPorIdioma(String idioma) {
        List<Libro> libros = libroRepositorio.findByIdioma(idioma);
        libros.forEach(System.out::println);
    }
}
