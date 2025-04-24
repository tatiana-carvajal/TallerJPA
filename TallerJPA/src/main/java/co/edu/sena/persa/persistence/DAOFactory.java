/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.persa.persistence;

/**
 *fecha: 24/4/2025
 * @author grupo 2 
 * descripcion: instanciar los DAO'S creados en la persistencia
 */
public class DAOFactory {
    public static ICareerDAO careerDAO = new CareerDAO();
    public static ICourseDAO courseDAO = new CourseDAO();
    public static ILocationDAO locationDAO = new LocationDAO();
    public static IPermissionDAO permissionDAO = new PermissionDAO();
    public static IPermissionTypeDAO permissionTypeDAO = new PermissionTypeDAO();
    public static IRolesDAO rolesDAO = new RolesDAO();
    public static IUsersDAO usersDAO = new UsersDAO();
    
    
    public static ICareerDAO getCareerDAO ()
    {
        return careerDAO;
    }
    
    public static ICourseDAO getCourseDAO ()
    {
        return courseDAO;
    }
    
    public static ILocationDAO getLocationDAO ()
    {
        return locationDAO;
    }
    
    public static IPermissionDAO getPermissionDAO ()
    {
        return permissionDAO;
    }
    
    public static IPermissionTypeDAO getIPermissionTypeDAO ()
    {
        return permissionTypeDAO;
       
    }
    
    public static IRolesDAO getRolesDAO ()
    {
        return rolesDAO;
    }
    
    public static IUsersDAO getuUsersDAO ()
    {
        return usersDAO;
    }
    
}
