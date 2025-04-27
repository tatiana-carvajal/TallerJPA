/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.persa.controllers;

import co.edu.sena.persa.model.Location;
import java.util.List;

/**
 * fecha : 24/4/2025
 * @author grupo 2
 *  objetivo:Interface de location
 */
public interface ILocationControllers {
    public void insert(Location location) throws  Exception;
    public void update(Location location) throws  Exception;
    public void delete (Long id) throws  Exception;
    public Location findById(Long id) throws Exception;
    public List<Location> findALL() throws Exception;
}
