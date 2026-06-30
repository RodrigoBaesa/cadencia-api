package com.cadencia.api.repositories;

import com.cadencia.api.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, String> {
    List<Module> findAllByOrderByOrderIndexAsc();
}
