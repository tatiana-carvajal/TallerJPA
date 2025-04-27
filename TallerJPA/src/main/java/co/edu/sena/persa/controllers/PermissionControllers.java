/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;
import co.edu.sena.persa.model.Permission;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  objetivo: Implementar la interface para controlar el model Permission
 */
public class PermissionControllers implements  IPermissionControllers{

    @Override
    public void insert(Permission permission) throws Exception {
         if (permission == null) {
            throw new Exception("El permiso es nulo.");
         }
         
         if (permission.getPermissionDate() == null)
         {
              throw new Exception("El Dato del permiso es obligatorio.");
         }
         
         if (permission.getStartTime() == null)
         {
             throw new Exception("La hora de inicio  es obligatoria.");
         }
         
         if (permission.getEndTime() == null)
         {
             throw new Exception("La hora fin es obligatoria.");
         }
         
         if (permission.getDepartureTime() == null)
         {
           throw new Exception("La hora de partida es obligatoria.");
         }
         
         if("".equals(permission.getReasons()))
         {
            throw new Exception("El motivo de salida  es obligatorio.");
         }
         
         if("".equals(permission.getStatus()))
         {
               throw new Exception("El estado es obligatorio.");
         }
         
         //FK's
         if (permission.getInstructorId() == null)
         {
             throw new Exception("El id del instructor es obligatorio.");
         }
         
         if (permission.getGuardId() == null)
         {
             throw new Exception("El id del guardia es obligatorio.");
         }
         
         if (permission.getLocationId() == null)
         {
             throw new Exception("La ubicacion es obligatorio.");
         }
         
         if (permission.getPermissionTypeId() == null)
         {
             throw new Exception("El tipo de permiso es obligatorio.");
         }
         
         //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionDAO().insert(permission);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
         
    }

    @Override
    public void update(Permission permission) throws Exception {
        if (permission == null) {
            throw new Exception("El permiso es  nulo.");
        }
        
        if (permission.getId() == null) {
            throw new Exception("La id es obligatoria.");
           }
         if (permission.getPermissionDate() == null)
         {
              throw new Exception("El Dato del permiso es obligatorio.");
         }
         
         if (permission.getStartTime() == null)
         {
             throw new Exception("La hora de inicio  es obligatoria.");
         }
         
         if (permission.getEndTime() == null)
         {
             throw new Exception("La hora fin es obligatoria.");
         }
         
         if (permission.getDepartureTime() == null)
         {
           throw new Exception("La hora de partida es obligatoria.");
         }
         
         if("".equals(permission.getReasons()))
         {
            throw new Exception("El motivo de salida  es obligatorio.");
         }
         
         if("".equals(permission.getStatus()))
         {
               throw new Exception("El estado es obligatorio.");
         }
         
         //FK's
         if (permission.getInstructorId() == null)
         {
             throw new Exception("El id del instructor es obligatorio.");
         }
         
         if (permission.getGuardId() == null)
         {
             throw new Exception("El id del guardia es obligatorio.");
         }
         
         if (permission.getLocationId() == null)
         {
             throw new Exception("La ubicacion es obligatorio.");
         }
         
         if (permission.getPermissionTypeId() == null)
         {
             throw new Exception("El tipo de permiso es obligatorio.");
         }
         
          //Consultar si el permiso existe en la bd
        
        Permission permissionExist = DAOFactory.getPermissionDAO().findById(permission.getId());
        if(permissionExist == null)
        {
            throw new Exception("El curso no existe");
        }
        
        
        //Merge
        
        permissionExist.setId(permission.getId());
        permissionExist.setPermissionDate(permission.getPermissionDate());
        permissionExist.setStartTime(permission.getStartTime());
        permissionExist.setEndTime(permission.getEndTime());
        permissionExist.setDepartureTime(permission.getDepartureTime());
        permissionExist.setReasons(permission.getReasons());
        permissionExist.setStatus(permission.getStatus());
        permissionExist.setInstructorId(permission.getInstructorId());
        permissionExist.setGuardId(permission.getGuardId());
        permissionExist.setLocationId(permission.getLocationId());
        permissionExist.setPermissionTypeId(permission.getPermissionTypeId());
        
         //Actualizar
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPermissionDAO().update(permission);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(Long id) throws Exception {
         if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Permission permissionExist = DAOFactory.getPermissionDAO().findById(id);
        if(permissionExist == null)
        {
             throw new Exception("No existe un permiso con ese id");
        }
        
       //eliminar
       
       EntityManagerHelper.beginTransaction();
       DAOFactory.getPermissionDAO().delete(permissionExist);
       EntityManagerHelper.commit();
       EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Permission findById(Long id) throws Exception {
        
        Permission permissionExist = DAOFactory.getPermissionDAO().findById(id);
          if (permissionExist == null)
          {
              throw  new Exception("No existe un permiso con ese id");
          }
          
          return DAOFactory.getPermissionDAO().findById(id);
    }

    @Override
    public List<Permission> findALL() throws Exception {
         return DAOFactory.getPermissionDAO().findALL();
    }
    
}
