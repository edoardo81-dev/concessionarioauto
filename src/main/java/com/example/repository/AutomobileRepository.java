package com.example.repository;

import com.example.model.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AutomobileRepository extends JpaRepository<Automobile, Long> {
    List<Automobile> findByPrezzoLessThan(Integer prezzo);
    List<Automobile> findByMarca(String marca);
}
