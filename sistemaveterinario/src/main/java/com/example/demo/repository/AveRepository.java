package com.example.demo.repository;

import com.example.demo.model.Ave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AveRepository extends JpaRepository<Ave, Long> {
    List<Ave> findByCapacidadeVooIgnoreCase(String capacidadeVoo);
    List<Ave> findByDomesticaTrue();

    long count();
}
