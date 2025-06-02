/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
//Importaciones de generales para el facil acceso a metodos y atributos:

import DataBase_Models.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOPrestamosImp extends DataBase.database implements Interfaces.DAOPrestamos {

    @Override
    public void Registrar(Prestamos prestamo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO prestamos(users_id,book_id, date_out) VALUES (?,?,?);");
            //Insercion de valores en los campos parametrizados:
            st.setInt(1, prestamo.getUsers_id());
            st.setInt(2, prestamo.getBook_id());
            st.setString(3, prestamo.getDate_out());
            //Ejecucion de la consulta:
            st.executeUpdate();
            //Cierre de la conexion con la base de datos
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void Modificar(Prestamos prestamo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE prestamos SET users_id = ?, book_id = ?, date_out = ?, date_return = ? WHERE id = ?");
            //Parametrizacion de comunicacion con los campos de la tabla
            st.setInt(1, prestamo.getUsers_id());
            st.setInt(2, prestamo.getBook_id());
            st.setString(3, prestamo.getDate_out());
            st.setString(4, prestamo.getDate_return());
            //NOTA: ...getId() para explicar.
            st.setInt(5, prestamo.getId());
            //Ejecucion y cierre de la consulta:
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public Prestamos getPrestamos(Usuarios usuario, Libros libro) throws Exception {
        //Inicializacion de la clase "prestamos":
        Prestamos prestamo = null;
        //Uso del "try{...} catch(Exception e){...} finally{...}" para evitar posibles errores de compilacion en el codigo
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM prestamos WHERE users_id = ? AND book_id = ? AND date_return IS NULL ORDER BY id DESC LIMIT 1");
            st.setInt(1, usuario.getId());
            st.setInt(2, libro.getId());
            //Uso del ResultSet y la consulta con la base de datos:
            ResultSet rs = st.executeQuery();
            //Bucle de ResultSet:
            while (rs.next()) {
                prestamo = new Prestamos();
                prestamo.setId(rs.getInt("id"));
                prestamo.setUsers_id(rs.getInt("users_id"));
                prestamo.setBook_id(rs.getInt("book_id"));
                prestamo.setDate_out(rs.getString("date_out"));
                prestamo.setDate_return(rs.getString("date_return"));
            }
            //Ejecucion de la consulta y cierre de la comunicicion con la base de datos.
            st.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return prestamo;
    }

    @Override
    public List<Prestamos> Listar() throws Exception {
        List<Prestamos> listaPrestamos = null;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM prestamos ORDER BY id DESC");
            //Muestra por lista:
            listaPrestamos = new ArrayList();
            //Ejecucion de la consulta:
            ResultSet rs = st.executeQuery();
            //Bucle de ResultSet:
            while (rs.next()) {
                Prestamos prestamo = new Prestamos();
                prestamo.setId(rs.getInt("id"));
                prestamo.setUsers_id(rs.getInt("users_id"));
                prestamo.setBook_id(rs.getInt("book_id"));
                prestamo.setDate_out(rs.getString("date_out"));
                prestamo.setDate_return(rs.getString("date_return"));
                //Consulta de los parametros y muestra en lista:
                listaPrestamos.add(prestamo);
            }
            //Cierre de comuenicaciones:
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        //Retorno del valor "listaPrestamos" con los parametros solicitados en la consulta: 
        return listaPrestamos;
    }
}

//CHECKPOINT: Martes, 04/02/2025 - 20:19
//NOTA: Implementar las funcionalidades de los otros paneles interactivos.
