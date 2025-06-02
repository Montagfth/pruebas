/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DataBase_Models.Usuarios;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOUsuarios {

    //Creacion de operaciones basicas del programa:
    //CREATE:
    public void Registrar(Usuarios usuario) throws Exception;

    //UPDATE:
    public void Modificar(Usuarios usuario) throws Exception;

    //DELETE:
    public void Eliminar(int usuarioID) throws Exception;

    //READ[NOTA: Para este caso, se mostrara con un arreglo de lista (<List>)]
    public List<Usuarios> Listar(String nombre) throws Exception;

    //Metodo de busqueda por ID de Usuario para la edicion:
    public Usuarios getUsuarioByID(int usuarioID) throws Exception;
    
    //Metodo de sancionamiento al usuario:
    public void sancionar(Usuarios usuario) throws Exception;
}
