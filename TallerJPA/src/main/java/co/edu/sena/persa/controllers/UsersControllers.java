/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;
import co.edu.sena.persa.model.Users;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  objetivo: Implementar la interface para controlar el model Users
 */
public class UsersControllers implements  IUsersControllers{

    @Override
    public void insert(Users users) throws Exception {
       if (users == null) {
            throw new Exception("El usuario es nulo.");
       }
       
       if("".equals(users.getFullname()))
       {
           throw new Exception("El nombre completo es obligatorio");
       }
       
       if("".equals(users.getEmail()))
       {
           throw new Exception("El correo es obligatorio");
       }
       
       if("".equals(users.getPassword()))
       {
           throw new Exception("La contraseña  es obligatoria");
       }
       
       if("".equals(users.getStatus()))
       {
           throw new Exception("El estado es obligatorio");
       }
       
       //FK's
       
       if(users.getRoleId() == null)
       {
           throw new Exception("El usuario obligatorio");
       }
    }

    @Override
    public void update(Users users) throws Exception {
         if (users == null) {
            throw new Exception("El usuario es  nulo.");
        }
        
        if (users.getId() == null) {
            throw new Exception("La id es obligatoria.");
           }
        
         if("".equals(users.getFullname()))
       {
           throw new Exception("El nombre completo es obligatorio");
       }
       
       if("".equals(users.getEmail()))
       {
           throw new Exception("El correo es obligatorio");
       }
       
       if("".equals(users.getPassword()))
       {
           throw new Exception("La contraseña  es obligatoria");
       }
       
       if("".equals(users.getStatus()))
       {
           throw new Exception("El estado es obligatorio");
       }
       
       //FK's
       
       if(users.getRoleId() == null)
       {
           throw new Exception("El usuario obligatorio");
       }
       
        //Consultar si usuaario existe en la bd
        
        Users userExist = DAOFactory.getuUsersDAO().findById(users.getId());
        if(userExist == null)
        {
            throw new Exception("El usuario no existe");
        }
        
        //Merge
        
        userExist.setId(users.getId());
        userExist.setFullname(users.getFullname());
        userExist.setEmail(users.getEmail());
        userExist.setPassword(users.getPassword());
        userExist.setStatus(users.getStatus());
        userExist.setRoleId(users.getRoleId());
        
          //Actualizar
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getuUsersDAO().update(users);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
         if(id == 0)
        {
            throw new Exception("El usuario es obligatorio");
        }
        
        Users usersExist = DAOFactory.getuUsersDAO().findById(id);
        if(usersExist == null)
        {
             throw new Exception("No existe un usuaario  con ese id");
        }
    }

    @Override
    public Users findById(Long id) throws Exception {
        Users usersExist = DAOFactory.getuUsersDAO().findById(id);
          if (usersExist == null)
          {
              throw  new Exception("No existe un usuario con ese id");
          }
          
          return DAOFactory.getuUsersDAO().findById(id);
    }

    @Override
    public List<Users> findALL() throws Exception {
         return DAOFactory.getuUsersDAO().findALL();
    }
    
}
