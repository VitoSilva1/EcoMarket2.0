package com.ecomarket.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.user_service.model.Venta;
import com.ecomarket.user_service.repository.VentaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class VentaService {
    

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> findAll(){
        return ventaRepository.findAll();
    }

    public Venta findById(long id){
        return ventaRepository.findById(id).get();
    }

    public Venta save(Venta venta){
        return ventaRepository.save(venta);
    }
    public void delete(Long id){
        ventaRepository.deleteById(id);
    }
}
