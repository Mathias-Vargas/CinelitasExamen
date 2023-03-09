/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelitas.cinelitas.service;

import com.cinelitas.cinelitas.entity.sala;
import com.cinelitas.cinelitas.repository.salarepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class salaservice implements Isalaservice {

    @Autowired //para unir ambos objetos/instancias. Ese autowired crea el puente entre el Repository y el Service
    private salarepository salarepository;

    @Override
    public List<sala> listsala() {
        return (List<sala>) salarepository.findAll();
    }

}
