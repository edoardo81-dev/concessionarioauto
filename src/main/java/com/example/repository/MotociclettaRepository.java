package com.example.repository;


import com.example.model.Motocicletta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MotociclettaRepository extends JpaRepository<Motocicletta, Long> {
    List<Motocicletta> findByPrezzoLessThan(Double prezzo);
    List<Motocicletta> findByMarca(String marca);
}

