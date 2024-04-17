package com.archico.ecommerce.service;

import java.util.List;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.archico.ecommerce.entity.Produk;
import com.archico.ecommerce.exception.ResourceNotFoundException;
import com.archico.ecommerce.repository.KategoriRepository;
import com.archico.ecommerce.repository.ProdukRepository;

@Service
public class ProdukService {
    
    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> findAll(){
        return produkRepository.findAll();
    }

    public Produk findById(String id){
        return produkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produk dengan id " + id + " tidak ditemukan"));
    }

    public Produk create(Produk produk) throws BadRequestException{
        if (!StringUtils.hasText(produk.getNama())) {
            throw new BadRequestException("Nama produk tidak boleh kosong");
        }

        if (produk.getKategori() == null) {
            throw new BadRequestException("Kategori tidak boleh kosong");
        }

        if (!StringUtils.hasText(produk.getKategori().getId())) {
            throw new BadRequestException("Kategori ID tidak boleh kosong");
        }

        kategoriRepository.findById(produk.getKategori().getId())
        .orElseThrow(() -> new BadRequestException(
            "Kategori ID " + produk.getKategori().getId() + " tidak ditemukan dalam database"));

        produk.setId(UUID.randomUUID().toString());
        return produkRepository.save(produk);
    }

    public Produk edit(Produk produk) throws BadRequestException{
        if (StringUtils.hasText(produk.getId())) {
            throw new BadRequestException("Produk ID harus diisi");
        }

        if (!StringUtils.hasText(produk.getNama())) {
            throw new BadRequestException("Nama produk tidak boleh kosong");
        }

        if (produk.getKategori() == null) {
            throw new BadRequestException("Kategori tidak boleh kosong");
        }

        if (!StringUtils.hasText(produk.getKategori().getId())) {
            throw new BadRequestException("Kategori ID tidak boleh kosong");
        }

        kategoriRepository.findById(produk.getKategori().getId())
                .orElseThrow(() -> new BadRequestException(
                        "Kategori ID " + produk.getKategori().getId() + " tidak ditemukan dalam database"));

        return produkRepository.save(produk);
    }

    public Produk ubahGambar(String id, String gambar){
        Produk produk = findById(id);
        return produkRepository.save(produk);
    }

    public void deleteById(String id){
        produkRepository.deleteById(id);
    }
}
