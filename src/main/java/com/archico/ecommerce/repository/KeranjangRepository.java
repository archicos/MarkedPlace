package com.archico.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archico.ecommerce.entity.Keranjang;

public interface KeranjangRepository extends JpaRepository<Keranjang, String>{
    
}
