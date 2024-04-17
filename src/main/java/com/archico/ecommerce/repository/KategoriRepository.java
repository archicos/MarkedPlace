package com.archico.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archico.ecommerce.entity.Kategori;

public interface KategoriRepository extends JpaRepository<Kategori, String>{
    
}
