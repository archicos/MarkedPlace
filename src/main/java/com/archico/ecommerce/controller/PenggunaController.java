package com.archico.ecommerce.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archico.ecommerce.entity.Pengguna;
import com.archico.ecommerce.service.PenggunaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated()")
public class PenggunaController {
    
    @Autowired
    private PenggunaService penggunaService;

    @GetMapping("/penggunas")
    public List<Pengguna> findAll(){
        return penggunaService.findAll();
    }

    @GetMapping("/penggunas/{id}")
    public Pengguna findById(@PathVariable("id") String id){
        return penggunaService.findById(id);
    }

    @PostMapping("/penggunas")
    public Pengguna create(@RequestBody Pengguna pengguna) throws BadRequestException {
        return penggunaService.create(pengguna);
    }

    @PutMapping("/penggunas")
    public Pengguna edit(@RequestBody Pengguna pengguna) throws BadRequestException {
        return penggunaService.edit(pengguna);
    }
    
    @DeleteMapping("/penggunas/{id}")
    public void deleteById(@PathVariable("id") String id){
        penggunaService.deleteById(id);
    }
}
