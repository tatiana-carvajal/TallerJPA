/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Career;
import co.edu.sena.persa.persistence.ICareerDAO;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class CareerController implements ICareerDAO {

    @Override
    public void insert(Career career) throws Exception {
       if (career == null) {
            throw new Exception("La carrera no puede ser nula.");
        }
       if (career.getName() == null || career.getName().isEmpty()) {
            throw new Exception("El nombre de la carrera no puede estar vacío.");
        }
       if (career.getType() == null || career.getType().isEmpty()) {
            throw new Exception("El tipo de carrera no puede estar vacío.");
        }
     
        System.out.println("Carrera insertada: " + career);
    }
     


    @Override
    public void update(Career career) throws Exception {
            if (career == null) {
            throw new Exception("La carrera no puede ser nula.");
        }
        if (career.getId() == null) {
            throw new Exception("El ID de la carrera no puede ser nulo para actualizar.");
        }
        
        System.out.println("Carrera actualizada: " + career);
    }

    @Override
    public void delete(Career career) throws Exception {
            if (career == null) {
            throw new Exception("La carrera no puede ser nula.");
        }
        if (career.getId() == null) {
            throw new Exception("El ID de la carrera no puede ser nulo para eliminar.");
        }
        
        System.out.println("Carrera eliminada: " + career);
    }

    @Override
    public Career findById(Long id) throws Exception {
            if (id == null) {
            throw new Exception("El ID de la carrera no puede ser nulo.");
        }
       
        System.out.println("Buscando carrera con ID: " + id);
        return new Career(id, "Nombre Ejemplo", "Tipo Ejemplo");
    }

    @Override
    public List<Career> findALL() throws Exception {
        System.out.println("Obteniendo todas las carreras.");
        return List.of(
            new Career(1L, "Ingeniería de Sistemas", "Tecnológica"),
            new Career(2L, "Administración de Empresas", "Profesional"));
    }
}


