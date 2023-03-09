/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cinelitas.cinelitas.service;

import com.cinelitas.cinelitas.entity.pelicula;
import java.util.List;

public interface Ipeliculaservice {
    public List<pelicula> getAllPelicula();
    public pelicula getPeliculaById (long id);
    public void savePelicula(pelicula pelicula);
    public void delete (long id);
}
