package com.archico.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archico.ecommerce.entity.Pesanan;

public interface PesananItemRepository extends JpaRepository<Pesanan, String> {
    
}
