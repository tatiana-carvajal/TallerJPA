/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Roles;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  objetivo: Implementar la interface para controlar el model Roles
 */
public class RolesControllers implements  IRolesControllers{

    @Override
    public void insert(Roles roles) throws Exception {
        
        if (roles == null) {
            throw new Exception("El rol es nulo.");
            
        }
        if ("".equals(roles.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        
          //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().insert(roles);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }

    @Override
    public void update(Roles roles) throws Exception {
         if (roles == null) {
            throw new Exception("El rol es  nulo.");
        }
        
        if (roles.getId() == null) {
            throw new Exception("La id es obligatoria.");
           }
        
         if ("".equals(roles.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
         
         //Consultar si roles existe en la bd
        
        Roles rolesExist = DAOFactory.getRolesDAO().findById(roles.getId());
        if(rolesExist == null)
        {
            throw new Exception("El rol no existe");
        }
        
        //Merge
        
        rolesExist.setId(roles.getId());
        rolesExist.setName(roles.getName());
        
        //Actualizar
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRolesDAO().update(roles);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Roles rolesExist = DAOFactory.getRolesDAO().findById(id);
        if(rolesExist == null)
        {
             throw new Exception("No existe un rol  con ese id");
        }
        
         //eliminar
       
       EntityManagerHelper.beginTransaction();
       DAOFactory.getRolesDAO().delete(rolesExist);
       EntityManagerHelper.commit();
       EntityManagerHelper.closeEntityManager();
    }

    @Override
    public Roles findById(Long id) throws Exception {
        
        Roles  rolesExist = DAOFactory.getRolesDAO().findById(id);
          if (rolesExist == null)
          {
              throw  new Exception("No existe un rol con ese id");
          }
          
          return DAOFactory.getRolesDAO().findById(id);
    }

    @Override
    public List<Roles> findALL() throws Exception {
         return DAOFactory.getRolesDAO().findALL();
    }
    
}
