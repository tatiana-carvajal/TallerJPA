/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Course;
import co.edu.sena.persa.persistence.ICourseDAO;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class CourseController implements ICourseDAO{

    @Override
    public void insert(Course course) throws Exception {
        if (course == null) {
            throw new Exception("El curso no puede ser nulo.");
        }
        if (course.getShift() == null || course.getShift().isEmpty()) {
            throw new Exception("El turno del curso no puede estar vacío.");
        }
        if (course.getTrimester() == null || course.getTrimester().isEmpty()) {
            throw new Exception("El trimestre del curso no puede estar vacío.");
        }
        if (course.getYear() <= 0) {
            throw new Exception("El año del curso debe ser mayor que cero.");
        }
        if (course.getStatus() == null || course.getStatus().isEmpty()) {
            throw new Exception("El estado del curso no puede estar vacío.");
        }
        if (course.getCareerId() == null) {
            throw new Exception("El curso debe estar asociado a una carrera.");
        }
      
        System.out.println("Curso insertado: " + course);
    }

    @Override
    public void update(Course course) throws Exception {
        if (course == null) {
            throw new Exception("El curso no puede ser nulo.");
        }
        if (course.getId() == null) {
            throw new Exception("El ID del curso no puede ser nulo para actualizar.");
        }
      
        System.out.println("Curso actualizado: " + course);
    }
    

    @Override
    public void delete(Course course) throws Exception {
        if (course == null) {
            throw new Exception("El curso no puede ser nulo.");
        }
        if (course.getId() == null) {
            throw new Exception("El ID del curso no puede ser nulo para eliminar.");
        }

        System.out.println("Curso eliminado: " + course);
    }

    @Override
    public Course findById(Long id) throws Exception {
            if (id == null) {
            throw new Exception("El ID del curso no puede ser nulo.");
        }
        
        System.out.println("Buscando curso con ID: " + id);
        return new Course(id, "Mañana", "Primer Trimestre", 2023, "Activo");
    }

    @Override
    public List<Course> findALL() throws Exception {
        System.out.println("Obteniendo todos los cursos.");
        return List.of(
            new Course(1L, "Mañana", "Primer Trimestre", 2023, "Activo"),
            new Course(2L, "Tarde", "Segundo Trimestre", 2023, "Inactivo")
        ); 
    }
    
}
