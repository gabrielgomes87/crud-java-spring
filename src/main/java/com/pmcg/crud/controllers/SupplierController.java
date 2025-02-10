package com.pmcg.crud.controllers;

import com.pmcg.crud.domain.supplier.Supplier;
import com.pmcg.crud.domain.supplier.SupplierRepository;
import com.pmcg.crud.domain.supplier.RequestSupplier;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierRepository repository;
    @GetMapping
    public ResponseEntity getAllSuppliers(){
        var allSuppliers = repository.findAll();
        return ResponseEntity.ok(allSuppliers);
    }

    @PostMapping
    public ResponseEntity registerSupplier(@RequestBody @Valid RequestSupplier data){
        Supplier newSupplier = new Supplier(data);
        repository.save(newSupplier);
        System.out.println(data);
        return ResponseEntity.ok().build();

    }

    @PutMapping
    @Transactional
    public ResponseEntity updateSupplier(@RequestBody @Valid RequestSupplier data){
        Optional<Supplier> optionalSupplier = repository.findById(data.id_sup());
        if (optionalSupplier.isPresent()) {
            Supplier supplier = optionalSupplier.get();
            supplier.setName(data.name());
            supplier.setCnpj(data.cnpj());
            supplier.setId_sup(data.id_sup());
            return ResponseEntity.ok(supplier);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
