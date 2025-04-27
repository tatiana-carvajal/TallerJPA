/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Course;
import co.edu.sena.persa.persistence.DAOFactory;
import co.edu.sena.persa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  objetivo: Implementar la interface para controlar el model Course
 */
public class CourseController implements ICourseControllers{

    @Override
    public void insert(Course course) throws Exception {
        if (course == null) {
            throw new Exception("El curso es nulo.");
        }
        
        if ("".equals(course.getShift())) {
            throw new Exception("La jornada  es obligatoria.");
        }
        if ("".equals(course.getTrimester())) {
            throw new Exception("El trimestre es obligatorio.");
        }
        if (course.getYear()== null) {
            throw new Exception("El año es obligatorio.");
        }
        if ("".equals(course.getStatus())) {
            throw new Exception("El estado es obligatorio.");
        }
        
        //FK's
        if (course.getCareerId() == null) {
            throw new Exception("El id del empleado es obligatorio.");
        }
      
      //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().insert(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Course course) throws Exception {
        if (course == null) {
            throw new Exception("El curso es  nulo.");
        }
        
        if (course.getId() == null) {
            throw new Exception("La id es obligatoria.");
           }
        
        if ("".equals(course.getShift()))
        {
            throw new Exception("La jornada es obligatoria");
        }
        
        if ("".equals(course.getTrimester()))
        {
            throw new Exception("El trimestre es obligatorio");
        }
        
        if (course.getYear() == null)
        {
            throw new Exception("El año es obligatorio");
        }
        
        if ("".equals(course.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        
        //FK's
        if (course.getCareerId() == null)
        {
            throw new Exception("El id es obligatorio");
        }
        
        //Consultar si el curso existe en la bd
        
        Course courseExist = DAOFactory.getCourseDAO().findById(course.getId());
        if(courseExist == null)
        {
            throw new Exception("El curso no existe");
        }
        
        //Merge
        
        courseExist.setId(course.getId());
        courseExist.setShift(course.getShift());
        courseExist.setCareerId(course.getCareerId());
        courseExist.setStatus(course.getStatus());
        courseExist.setTrimester(course.getTrimester());
        courseExist.setYear(course.getYear());
        
        //Actualizar
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCourseDAO().update(course);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
    

    @Override
    public void delete(Long id) throws Exception {
        
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        
        Course courseExist = DAOFactory.getCourseDAO().findById(id);
        if(courseExist == null)
        {
             throw new Exception("No existe un curso con ese id");
        }
        
       //eliminar
       
       EntityManagerHelper.beginTransaction();
       DAOFactory.getCourseDAO().delete(courseExist);
       EntityManagerHelper.commit();
       EntityManagerHelper.closeEntityManager();
       
    }
      

    @Override
    public Course findById(Long id) throws Exception {
        
          Course courseExist = DAOFactory.getCourseDAO().findById(id);
          if (courseExist == null)
          {
              throw  new Exception("No existe un curso con ese id");
          }
          
          return DAOFactory.getCourseDAO().findById(id);
    }

    @Override
    public List<Course> findALL() throws Exception {
        return DAOFactory.getCourseDAO().findALL();
    }

}