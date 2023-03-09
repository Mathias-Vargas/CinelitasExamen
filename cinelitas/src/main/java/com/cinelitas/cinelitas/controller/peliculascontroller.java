
package com.cinelitas.cinelitas.controller;

import com.cinelitas.cinelitas.entity.sala;
import com.cinelitas.cinelitas.entity.pelicula;
import com.cinelitas.cinelitas.service.Isalaservice;
import com.cinelitas.cinelitas.service.Ipeliculaservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class peliculascontroller {
    
    @Autowired
    private Isalaservice salaservice;

    @Autowired
    private Ipeliculaservice peliculaservice;
    
    @GetMapping("/pelicula") // aca definimos el endpoint para el html persona. Se triggerea ese mapping 
    //el restful api ejecuta todo mediante requests.
    public String index(Model model) { //el model permite pasarle al frontend la info mediante el addAttribute
        List<pelicula> listaPelicula = peliculaservice.getAllPelicula();
        model.addAttribute("titulo", "Tabla Peliculas");
        model.addAttribute("pelicula", listaPelicula);
        return "peliculas";

    }

    @GetMapping("/peliculaN")
    public String crearPelicula(Model model) {
        List<sala> listaSalas = salaservice.listsala();
        model.addAttribute("pelicula", new pelicula());
        model.addAttribute("salas", listaSalas);
        return "crear";

    }

    @GetMapping("delete/{id}")
    public String eliminarPelicula(@PathVariable("id") Long idPelicula) {
        peliculaservice.delete(idPelicula);
        return "redirect:/pelicula";
    }

    @PostMapping("/save")
    public String guardarPelicula(@ModelAttribute pelicula pelicula) {
        peliculaservice.savePelicula(pelicula);
        return "redirect:/pelicula";
    }

    @GetMapping("editPelicula/{id}")
    public String editarPelicula(@PathVariable("id") Long idPelicula, Model model) {
        pelicula pelicula = peliculaservice.getPeliculaById(idPelicula);
        List<sala> listaSalas = salaservice.listsala();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("sala", listaSalas);
        return "crear";
    }
    
}
