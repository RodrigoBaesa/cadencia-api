package com.cadencia.api.controllers;

import com.cadencia.api.entities.Module;
import com.cadencia.api.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleRepository moduleRepository;

    @GetMapping
    public ResponseEntity<List<Module>> getAllModules() {
        return ResponseEntity.ok(moduleRepository.findAllByOrderByOrderIndexAsc());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable String id) {
        return moduleRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
