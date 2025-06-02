/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DataBase_Models.Libros;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public interface DAOLibros {

    //Creacion de operaciones basicas del programa:
    //CREATE:
    public void Registrar(Libros libro) throws Exception;

    //UPDATE:
    public void Modificar(Libros libro) throws Exception;

    //DELETE:
    public void Eliminar(int libroID) throws Exception;

    //READ[NOTA: Para este caso, se mostrara con un arreglo de lista (<List>)]
    public List<Libros> Listar(String nombrelibro) throws Exception;

    public Libros getLibrobyID(int libroID) throws Exception;
}
