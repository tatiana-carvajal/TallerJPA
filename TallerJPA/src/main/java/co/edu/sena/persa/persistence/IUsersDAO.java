/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Users;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  interface de users
 */
public interface IUsersDAO {
    public void insert(Users users) throws  Exception;
    public void update(Users users) throws  Exception;
    public void delete (Users users) throws  Exception;
    public Users findById(Long id) throws Exception;
    public List<Users> findALL() throws Exception;
}
