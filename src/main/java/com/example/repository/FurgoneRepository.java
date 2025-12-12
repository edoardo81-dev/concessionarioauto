package com.example.repository;


import com.example.model.Furgone;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FurgoneRepository extends JpaRepository<Furgone, Long> {
    List<Furgone> findByPrezzoLessThan(Double prezzo);
    List<Furgone> findByMarca(String marca);
}
