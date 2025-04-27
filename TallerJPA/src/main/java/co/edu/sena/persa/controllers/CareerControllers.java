/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Career;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  objetivo: Implementar la interface para controlar el model Career
 */
public class CareerControllers  implements  ICareerControllers{

    @Override
    public void insert(Career career) throws Exception {
        
          if (career == null) {
            throw new Exception("La carrera es nulo.");
        }
          
          if("".equals(career.getName()))
          {
              throw new Exception("El nombre es obligatorio.");
          }
          
          if ("".equals(career.getType()))
          {
              throw new Exception("El tipo es obligatorio.");
          }
          
          //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCareerDAO().insert(career);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Career career) throws Exception {
         if (career == null) {
            throw new Exception("La carrera es nulo.");
        }
          
          if("".equals(career.getName()))
          {
              throw new Exception("El nombre es obligatorio.");
          }
          
          if ("".equals(career.getType()))
          {
              throw new Exception("El tipo es obligatorio.");
          }
          
           if (career.getId() == null) {
            throw new Exception("La id es obligatoria.");
           }
          
          //consultar si la carrera es obligatoria
          
          Career careerExist = DAOFactory.getCareerDAO().findById(career.getId());
          if (careerExist == null)
          {
               throw new Exception("La carrera o no existe");
          }
          
          //Merge
          
         careerExist.setId(career.getId());
         careerExist.setName(career.getName());
         careerExist.setType(career.getType());
         
         //Actualizar
         
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCareerDAO().update(career);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long id) throws Exception {
        
         if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
         
          Career careerExist = DAOFactory.getCareerDAO().findById(id);
        if(careerExist == null)
        {
             throw new Exception("No existe una carrera con ese id");
        }
        
       //eliminar
       
       EntityManagerHelper.beginTransaction();
       DAOFactory.getCareerDAO().delete(careerExist);
       EntityManagerHelper.commit();
       EntityManagerHelper.closeEntityManager();
       
        
    }

    @Override
    public Career findById(Long id) throws Exception {
         Career careerExist = DAOFactory.getCareerDAO().findById(id);
          if (careerExist == null)
          {
              throw  new Exception("No existe una carrera con ese id");
          }
          
          return DAOFactory.getCareerDAO().findById(id);
    }
   

    @Override
    public List<Career> findALL() throws Exception {
        return DAOFactory.getCareerDAO().findALL();
    }
    
}
