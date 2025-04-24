/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.PermissionType;
import co.edu.sena.persa.persistence.IPermissionTypeDAO;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class PermissionTypeController implements IPermissionTypeDAO{

    @Override
    public void insert(PermissionType permissionType) throws Exception {
               if (permissionType == null) {
            throw new Exception("El tipo de permiso no puede ser nulo.");
        }
        if (permissionType.getName() == null || permissionType.getName().isEmpty()) {
            throw new Exception("El nombre del tipo de permiso no puede estar vacío.");
        }

        System.out.println("Tipo de permiso insertado: " + permissionType);
    }

    @Override
    public void update(PermissionType permissionType) throws Exception {
               if (permissionType == null) {
            throw new Exception("El tipo de permiso no puede ser nulo.");
        }
        if (permissionType.getId() == null) {
            throw new Exception("El ID del tipo de permiso no puede ser nulo para actualizar.");
        }

        System.out.println("Tipo de permiso actualizado: " + permissionType);
    }

    @Override
    public void delete(PermissionType permissionType) throws Exception {
       if (permissionType == null) {
            throw new Exception("El tipo de permiso no puede ser nulo.");
        }
        if (permissionType.getId() == null) {
            throw new Exception("El ID del tipo de permiso no puede ser nulo para eliminar.");
        }

        System.out.println("Tipo de permiso eliminado: " + permissionType);
    }

    @Override
    public PermissionType findById(Long id) throws Exception {
            if (id == null) {
            throw new Exception("El ID del tipo de permiso no puede ser nulo.");
        }

        System.out.println("Buscando tipo de permiso con ID: " + id);
        return new PermissionType(id, "Permiso Especial");
    }

    @Override
    public List<PermissionType> findALL() throws Exception {
        System.out.println("Obteniendo todos los tipos de permiso.");
        return List.of(
            new PermissionType(1L, "Permiso General"),
            new PermissionType(2L, "Permiso Especial")
        );
    }

}
