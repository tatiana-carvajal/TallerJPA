/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Permission;
import co.edu.sena.persa.persistence.IPermissionDAO;
import java.util.Date;
import java.util.List;
import static org.eclipse.persistence.internal.sessions.coordination.corba.sun.CommandDataHelper.id;
import static org.eclipse.persistence.internal.sessions.coordination.corba.sun.SunCORBAConnectionHelper.id;
import static org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.id;

/**
 *
 * @author USUARIO
 */
public class PermissionController implements IPermissionDAO{

    @Override
    public void insert(Permission permission) throws Exception {
        if (permission == null) {
            throw new Exception("El permiso no puede ser nulo.");
        }
        if (permission.getPermissionDate() == null) {
            throw new Exception("La fecha del permiso no puede ser nula.");
        }
        if (permission.getStartTime() == null) {
            throw new Exception("La hora de inicio del permiso no puede ser nula.");
        }
        if (permission.getEndTime() == null) {
            throw new Exception("La hora de finalización del permiso no puede ser nula.");
        }
        if (permission.getReasons() == null || permission.getReasons().isEmpty()) {
            throw new Exception("Las razones del permiso no pueden estar vacías.");
        }
        if (permission.getStatus() == null || permission.getStatus().isEmpty()) {
            throw new Exception("El estado del permiso no puede estar vacío.");
        }
        if (permission.getLocationId() == null) {
            throw new Exception("El permiso debe estar asociado a una ubicación.");
        }
        if (permission.getPermissionTypeId() == null) {
            throw new Exception("El permiso debe estar asociado a un tipo de permiso.");
        }
        if (permission.getInstructorId() == null) {
            throw new Exception("El permiso debe estar asociado a un instructor.");
        }
        if (permission.getGuardId() == null) {
            throw new Exception("El permiso debe estar asociado a un guardia.");
        }
        
        System.out.println("Permiso insertado: " + permission);
    }

    @Override
    public void update(Permission permission) throws Exception {
        if (permission == null) {
            throw new Exception("El permiso no puede ser nulo.");
        }
        if (permission.getId() == null) {
            throw new Exception("El ID del permiso no puede ser nulo para actualizar.");
        }
        
        System.out.println("Permiso actualizado: " + permission);
    }

    @Override
    public void delete(Permission permission) throws Exception {
         if (permission == null) {
            throw new Exception("El permiso no puede ser nulo.");
        }
        if (permission.getId() == null) {
            throw new Exception("El ID del permiso no puede ser nulo para eliminar.");
        }
       
        System.out.println("Permiso eliminado: " + permission);
        
    }

    @Override
    public Permission findById(Long id) throws Exception {
            if (id == null) {
            throw new Exception("El ID del permiso no puede ser nulo.");
        }

        System.out.println("Buscando permiso con ID: " + id);
        return new Permission(
            id,
            new Date(), 
            new Date(), 
            new Date(), 
            "Razón de ejemplo",
            "Activo"
        );
       
    }

    @Override
    public List<Permission> findALL() throws Exception {

                System.out.println("Obteniendo todos los permisos.");
        return List.of(
            new Permission(
                1L,
                new Date(),
                new Date(),
                new Date(),
                "Reunión de trabajo",
                "Activo"
            ),
            new Permission(
                2L,
                new Date(),
                new Date(),
                new Date(),
                "Emergencia médica",
                "Inactivo"
            )
        );
    }
    
}
