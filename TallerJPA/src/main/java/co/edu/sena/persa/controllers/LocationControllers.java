/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Location;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  objetivo: Implementar la interface para controlar el model Location
 */
public class LocationControllers  implements  ILocationControllers{

    @Override
    public void insert(Location location) throws Exception {
        
          if (location== null) {
            throw new Exception("La ubicacion es nula.");
        }
          
          if("".equals(location.getName()))
          {
                throw new Exception("La ubicacion es obligatoria.");
          }
          
          if("".equals(location.getAddress()))
          {
                throw new Exception("La dirrecion es obligatoria.");
          }
          
          //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLocationDAO().insert(location);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }

    @Override
    public void update(Location location) throws Exception {
          if (location== null) {
            throw new Exception("La ubicacion es nula.");
        }
          
          if("".equals(location.getName()))
          {
                throw new Exception("La ubicacion es obligatoria.");
          }
          
          if("".equals(location.getAddress()))
          {
                throw new Exception("La dirrecion es obligatoria.");
          }
          
          if(location.getId() == null)
          {
              throw new Exception("La id es obligatoria.");
          }
          //Consultar si la ubicacion existe en la bd
        
        Location locationExist = DAOFactory.getLocationDAO().findById(location.getId());
        if(locationExist == null)
        {
            throw new Exception("El curso no existe");
        }
          //Merge
          locationExist.setId(location.getId());
          locationExist.setName(location.getName());
          locationExist.setAddress(location.getAddress());
          
           //Actualizar
         
        EntityManagerHelper.beginTransaction();
        DAOFactory.getLocationDAO().update(location);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
          
          
    }

    @Override
    public void delete(Long id) throws Exception {
          if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
         
          Location locationExist = DAOFactory.getLocationDAO().findById(id);
        if(locationExist == null)
        {
             throw new Exception("No existe una ubicacion con ese id");
        }
        
       //eliminar
       
       EntityManagerHelper.beginTransaction();
       DAOFactory.getLocationDAO().delete(locationExist);
       EntityManagerHelper.commit();
       EntityManagerHelper.closeEntityManager();
       
    }

    @Override
    public Location findById(Long id) throws Exception {
        Location locationExist = DAOFactory.getLocationDAO().findById(id);
          if (locationExist == null)
          {
              throw  new Exception("No existe una ubicacion con ese id");
          }
          
          return DAOFactory.getLocationDAO().findById(id);
    }

    @Override
    public List<Location> findALL() throws Exception {
         return DAOFactory.getLocationDAO().findALL();
    }
    
}
