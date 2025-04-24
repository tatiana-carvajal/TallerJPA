/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Users;
import co.edu.sena.persa.persistence.IUsersDAO;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class UsersControllers implements IUsersDAO{

    @Override
    public void insert(Users users) throws Exception {
        if (users == null) {
            throw new Exception("El usuario no puede ser nulo.");
        }
        if (users.getFullname() == null || users.getFullname().isEmpty()) {
            throw new Exception("El nombre completo del usuario no puede estar vacío.");
        }
        if (users.getEmail() == null || users.getEmail().isEmpty()) {
            throw new Exception("El correo electrónico del usuario no puede estar vacío.");
        }
        if (users.getPassword() == null || users.getPassword().isEmpty()) {
            throw new Exception("La contraseña del usuario no puede estar vacía.");
        }
        if (users.getStatus() == null || users.getStatus().isEmpty()) {
            throw new Exception("El estado del usuario no puede estar vacío.");
        }
        if (users.getRoleId() == null) {
            throw new Exception("El usuario debe estar asociado a un rol.");
        }

        System.out.println("Usuario insertado: " + users);
        
    }

    @Override
    public void update(Users users) throws Exception {
        if (users == null) {
            throw new Exception("El usuario no puede ser nulo.");
        }
        if (users.getId() == null) {
            throw new Exception("El ID del usuario no puede ser nulo para actualizar.");
        }

        System.out.println("Usuario actualizado: " + users);
      
    }

    @Override
    public void delete(Users users) throws Exception {
        if (users == null) {
            throw new Exception("El usuario no puede ser nulo.");
        }
        if (users.getId() == null) {
            throw new Exception("El ID del usuario no puede ser nulo para eliminar.");
        }
        
        System.out.println("Usuario eliminado: " + users);
       
    }

    @Override
    public Users findById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("El ID del usuario no puede ser nulo.");
        }
    
        System.out.println("Buscando usuario con ID: " + id);
        return new Users(id, "Juan Pérez", "juan@example.com", "password123", "Activo");
       
    }

    @Override
    public List<Users> findALL() throws Exception {
                System.out.println("Obteniendo todos los usuarios.");
        return List.of(
            new Users(1L, "María López", "maria@example.com", "securepass", "Activo"),
            new Users(2L, "Carlos Gómez", "carlos@example.com", "mypassword", "Inactivo"));
    }
    
}
