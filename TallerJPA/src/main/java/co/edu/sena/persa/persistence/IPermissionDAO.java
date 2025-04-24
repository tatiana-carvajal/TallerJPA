/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.persistence;

import co.edu.sena.persa.model.Permission;
import java.util.List;
/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  interface de permission
 */
public interface IPermissionDAO {
    public void insert(Permission permission) throws  Exception;
    public void update(Permission permission) throws  Exception;
    public void delete (Permission permission) throws  Exception;
    public Permission findById(Long id) throws Exception;
    public List<Permission> findALL() throws Exception;
}
