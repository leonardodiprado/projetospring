package com.example.demo.repository;

import com.example.demo.model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CachorroRepository extends JpaRepository<Cachorro, Long> {
    List<Cachorro> findByCorPelagemIgnoreCase(String corPelagem);

    long count();
}
