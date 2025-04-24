/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Career;
import java.util.List;
import javax.persistence.Query;

/**
 *Fecha: 24/4/2025
 * @author Grupo2 
 * Descripcion: Se implementa interface de career
 */
public class CareerDAO  implements  ICareerDAO{

    @Override
    public void insert(Career career) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(career);
        } catch (RuntimeException e) {
            throw e;
        }
    }
    

    @Override
    public void update(Career career) throws Exception {
    try {
            EntityManagerHelper.getEntityManager().merge (career);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Career career) throws Exception {
         try {
            EntityManagerHelper.getEntityManager().remove( career);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Career findById(Long id) throws Exception {
        try {
             return EntityManagerHelper.getEntityManager().find(Career.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Career> findALL() throws Exception {
         try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Career.findAll");
            return query.getResultList();
        } catch (RuntimeException e) {
            throw  e;
        }
    }
    
}
