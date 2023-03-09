/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinelitas.cinelitas.service;

import com.cinelitas.cinelitas.entity.pelicula;
import com.cinelitas.cinelitas.repository.pelicularepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class peliculaservice implements Ipeliculaservice {

    @Autowired
    private pelicularepository pelicularepository;

    @Override
    public List<pelicula> getAllPelicula() {
        return (List<pelicula>) pelicularepository.findAll();
    }

    @Override
    public pelicula getPeliculaById(long id) {
        return pelicularepository.findById(id).orElse(null);
    }

    @Override
    public void savePelicula(pelicula pelicula) {
        pelicularepository.save(pelicula);
    }

    @Override
    public void delete(long id) {
        pelicularepository.deleteById(id);
    }

}
