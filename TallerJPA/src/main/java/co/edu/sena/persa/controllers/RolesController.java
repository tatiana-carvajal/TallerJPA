/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Roles;
import co.edu.sena.persa.persistence.IRolesDAO;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class RolesController implements IRolesDAO{

    @Override
    public void insert(Roles roles) throws Exception {
        if (roles == null) {
            throw new Exception("El rol no puede ser nulo.");
        }
        if (roles.getName() == null || roles.getName().isEmpty()) {
            throw new Exception("El nombre del rol no puede estar vacío.");
        }
       
        System.out.println("Rol insertado: " + roles);
       
    }

    @Override
    public void update(Roles roles) throws Exception {
        if (roles == null) {
            throw new Exception("El rol no puede ser nulo.");
        }
        if (roles.getId() == null) {
            throw new Exception("El ID del rol no puede ser nulo para actualizar.");
        }
        
        System.out.println("Rol actualizado: " + roles);
        
    }

    @Override
    public void delete(Roles roles) throws Exception {
        if (roles == null) {
            throw new Exception("El rol no puede ser nulo.");
        }
        if (roles.getId() == null) {
            throw new Exception("El ID del rol no puede ser nulo para eliminar.");
        }
      
        System.out.println("Rol eliminado: " + roles);
       
    }

    @Override
    public Roles findById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("El ID del rol no puede ser nulo.");
        }
   
        System.out.println("Buscando rol con ID: " + id);
        return new Roles(id, "Administrador");
       
    }

    @Override
    public List<Roles> findALL() throws Exception {
        System.out.println("Obteniendo todos los roles.");
        return List.of(
            new Roles(1L, "Administrador"),
            new Roles(2L, "Instructor"),
            new Roles(3L, "Estudiante")
        ); 
    }
    
}
