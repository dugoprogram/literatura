package com.alura.literatura.repositorio;

import com.alura.literatura.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    List<Autor> findByFechaFallecimientoIsNullOrFechaFallecimientoGreaterThanEqual(int anio);
}
