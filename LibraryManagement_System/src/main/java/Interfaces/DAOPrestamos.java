/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DataBase_Models.Prestamos;
import java.util.List;
import DataBase_Models.*;

/**
 *
 * @author Fabrizio
 */
public interface DAOPrestamos {

    //Creacion de operaciones basicas del programa:
    //CREATE:
    public void Registrar(Prestamos prestamo) throws Exception;

    //UPDATE:
    public void Modificar(Prestamos prestamo) throws Exception;

    //DELETE:
    //public void Eliminar(Prestamos prestamo) throws Exception;
    //NOTA: Se cambia la funcionalidad de elimanar, ya que no se requiere para el presente panel.
    public Prestamos getPrestamos(Usuarios usuario, Libros libro) throws Exception;

    //READ[NOTA: Para este caso, se mostrara con un arreglo de lista (<List>)]
    //NOTA: Caso de eliminacion de registro.
    public List<Prestamos> Listar() throws Exception;
}
