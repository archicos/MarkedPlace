package com.archico.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archico.ecommerce.entity.Pesanan;

public interface PesananRepository extends JpaRepository<Pesanan, String> {
    
}
