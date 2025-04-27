/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.PermissionType;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  objetivo: Implementar la interface para controlar el model PermissionType
 */
public class PermissionTypeControllers  implements IPermissionTypeControllers{

    @Override
    public void insert(PermissionType permissionType) throws Exception {
         if (permissionType == null) {
            throw new Exception("El tipo de permiso es nulo.");
            
        }
        if ("".equals(permissionType.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
          //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getIPermissionTypeDAO().insert(permissionType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(PermissionType permissionType) throws Exception {
         if (permissionType == null) {
            throw new Exception("El tipo de permiso es  nulo.");
        }
        
        if (permissionType.getId() == null) {
            throw new Exception("La id es obligatoria.");
           }
        
         if ("".equals(permissionType.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
         
         //Consultar si el permissiontype existe en la bd
        
        PermissionType permissionTypeExist = DAOFactory.getIPermissionTypeDAO().findById(permissionType.getId());
        if(permissionTypeExist == null)
        {
            throw new Exception("El tipo de permiso no existe");
        }
        
        //Merge
        permissionTypeExist.setId(permissionType.getId());
        permissionTypeExist.setName(permissionType.getName());
        
        //Actualizar
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getIPermissionTypeDAO().update(permissionType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
         
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        PermissionType permissionTypeExist = DAOFactory.getIPermissionTypeDAO().findById(id);
        if(permissionTypeExist == null)
        {
             throw new Exception("No existe un tipo de permiso con ese id");
        }
        
         //eliminar
       
       EntityManagerHelper.beginTransaction();
       DAOFactory.getIPermissionTypeDAO().delete(permissionTypeExist);
       EntityManagerHelper.commit();
       EntityManagerHelper.closeEntityManager();
    }

    @Override
    public PermissionType findById(Long id) throws Exception {
        
        PermissionType permissionTypeExist = DAOFactory.getIPermissionTypeDAO().findById(id);
          if (permissionTypeExist == null)
          {
              throw  new Exception("No existe un tipo de dato con ese id");
          }
          
          return DAOFactory.getIPermissionTypeDAO().findById(id);
    }

    @Override
    public List<PermissionType> findALL() throws Exception {
         return DAOFactory.getIPermissionTypeDAO().findALL();
    }
    
}
