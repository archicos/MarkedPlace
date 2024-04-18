package com.archico.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archico.ecommerce.entity.PesananItem;

public interface PesananItemRepository extends JpaRepository<PesananItem, String> {
    
}
