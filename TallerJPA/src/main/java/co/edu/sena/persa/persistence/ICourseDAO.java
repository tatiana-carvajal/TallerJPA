/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Course;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  interface de course
 */
public interface ICourseDAO {
    public void insert(Course course) throws  Exception;
    public void update(Course course) throws  Exception;
    public void delete (Course course) throws  Exception;
    public Course findById(Long id) throws Exception;
    public List<Course> findALL() throws Exception;
}
