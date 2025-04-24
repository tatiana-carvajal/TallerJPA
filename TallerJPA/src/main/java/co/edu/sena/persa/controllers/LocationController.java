/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Location;
import co.edu.sena.persa.persistence.ILocationDAO;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class LocationController implements ILocationDAO{

    @Override
    public void insert(Location location) throws Exception {
        if (location == null) {
            throw new Exception("La ubicación no puede ser nula.");
        }
        if (location.getName() == null || location.getName().isEmpty()) {
            throw new Exception("El nombre de la ubicación no puede estar vacío.");
        }
        if (location.getAddress() == null || location.getAddress().isEmpty()) {
            throw new Exception("La dirección de la ubicación no puede estar vacía.");
        }
        
        System.out.println("Ubicación insertada: " + location);
    }

    @Override
    public void update(Location location) throws Exception {
        if (location == null) {
            throw new Exception("La ubicación no puede ser nula.");
        }
        if (location.getId() == null) {
            throw new Exception("El ID de la ubicación no puede ser nulo para actualizar.");
        }

        System.out.println("Ubicación actualizada: " + location);
    }

    @Override
    public void delete(Location location) throws Exception {
        if (location == null) {
            throw new Exception("La ubicación no puede ser nula.");
        }
        if (location.getId() == null) {
            throw new Exception("El ID de la ubicación no puede ser nulo para eliminar.");
        }

        System.out.println("Ubicación eliminada: " + location);
    }

    @Override
    public Location findById(Long id) throws Exception {
        if (id == null) {
        throw new Exception("El ID de la ubicación no puede ser nulo.");
        }
        // Aquí se debería agregar la lógica para buscar la ubicación en la base de datos.
        System.out.println("Buscando ubicación con ID: " + id);
        return new Location(id, "Sede Principal", "Calle 123, Bogotá");
        
    }

    @Override
    public List<Location> findALL() throws Exception {
        System.out.println("Obteniendo todas las ubicaciones.");
        return List.of(
            new Location(1L, "Sede Norte", "Carrera 45 # 67-89"),
            new Location(2L, "Sede Sur", "Calle 30 # 15-20")
        );
    }
    
}
