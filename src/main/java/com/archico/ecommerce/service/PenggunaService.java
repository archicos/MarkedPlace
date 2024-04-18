package com.archico.ecommerce.service;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.archico.ecommerce.entity.Pengguna;
import com.archico.ecommerce.exception.ResourceNotFoundException;
import com.archico.ecommerce.repository.PenggunaRepository;

@Service
public class PenggunaService {
    
    @Autowired
    private PenggunaRepository penggunaRepository;

    public Pengguna findById(String id){
        return penggunaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pengguna dengan id " + id + " tidak ditemukan"));
    }

    public List<Pengguna> findAll() {
        return penggunaRepository.findAll();
    }

    public Pengguna create(Pengguna pengguna) throws BadRequestException{
        if (!StringUtils.hasText(pengguna.getId())) {
            throw new BadRequestException("Username harus diisi");
        }

        if (penggunaRepository.existsById(pengguna.getId())) {
            throw new BadRequestException("Username " + pengguna.getId() + " sudah terdaftar");
        }

        if (!StringUtils.hasText(pengguna.getEmail())) {
            throw new BadRequestException("Email harus diisi");
        }

        if (penggunaRepository.existsByEmail(pengguna.getEmail())) {
            throw new BadRequestException("Email " + pengguna.getEmail() + " sudah terdaftar");
        }

        pengguna.setIsAktif(true);

        return penggunaRepository.save(pengguna);
    }

    public Pengguna edit(Pengguna pengguna) throws BadRequestException{
        if (penggunaRepository.existsById(pengguna.getId())) {
            throw new BadRequestException("Username " + pengguna.getId() + " sudah terdaftar");
        }

        if (penggunaRepository.existsByEmail(pengguna.getEmail())) {
            throw new BadRequestException("Email " + pengguna.getEmail() + " sudah terdaftar");
        }

        return penggunaRepository.save(pengguna);
    }

    public void deleteById(String id){
        penggunaRepository.deleteById(id);
    }
}
