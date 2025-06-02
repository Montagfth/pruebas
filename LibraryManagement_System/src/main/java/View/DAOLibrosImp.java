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
public class DAOLibrosImp extends DataBase.database implements Interfaces.DAOLibros {

    //CHECKPOINT: Domingo, 26/01/2025 - 13:50
    //TO DO: Programar el accionamiento de cada una de los DAOLibros
    //NOTA: Tomar la guia del modelo de Usuarios.java y DAOUsuariosImp.java en el paquete de "Views_panels" y el "view"
    //CHECKPOINT: Lunes, 27/01/2025
    @Override
    public void Registrar(Libros libro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Modificar(Libros libro) throws Exception {
        //CHECKPOINT: Jueves, 30/01/2025
        //NOTA: Implementacion de la funcionalidad "Modificar" para la comunicacion de los datos con la clase
        //      AdicionesLibro.java
        //CHECKPOINT: Jueves, 30/01/2025 - 17:09
        //NOTA: Continuar implementando las funcionalidades de los botones.
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE libros SET title = ?, fecha = ?, author = ?, category = ?, edit = ?, lang = ?, pages = ?, descripcion = ?, ejemplares = ?, stock = ?, available = ? WHERE id = ?;");
            st.setString(1, libro.getTitle());
            st.setString(2, libro.getfecha());
            st.setString(3, libro.getAuthor());
            st.setString(4, libro.getCategory());
            st.setString(5, libro.getEdit());
            st.setString(6, libro.getLang());
            st.setString(7, libro.getPages());
            st.setString(8, libro.getDescripcion());
            st.setString(9, libro.getEjemplares());
            st.setInt(10, libro.getStock());
            st.setInt(11, libro.getAvailable());
            //Busqueda por usuarioID seleccionado por el cliente:
            st.setInt(12, libro.getId());
            //Ejecucion de la consulta y cerrado de la comunicacion:
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    //CHECKPOINT: Miercoles, 12/02/2025 - 19:36
    //NOTA: Revision de la implemetacion de la funcionalidad "Eliminar" para "DAOLibrosImpl.java"

    @Override
    public List<Libros> Listar(String nombrelibro) throws Exception {
        //NOTA: Areglar el metodo
        List<Libros> listalibros = null;
        //Metodo de implementacion para casos de errores en compilacion:
        try {
            //Instruciones de accionamiento de la consulta:
            this.Conectar();
            String Query = nombrelibro.isEmpty() ? "SELECT * FROM libros;" : "SELECT * FROM libros WHERE title LIKE '%" + nombrelibro + "%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            listalibros = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Libros libro = new Libros();
                //Solicitud de los parametro ha solicitar:
                libro.setId(rs.getInt("id"));
                libro.setTitle(rs.getString("title"));
                libro.setfecha(rs.getString("fecha"));
                libro.setAuthor(rs.getString("author"));
                libro.setCategory(rs.getString("category"));
                libro.setEdit(rs.getString("edit"));
                libro.setLang(rs.getString("lang"));
                libro.setPages(rs.getString("pages"));
                libro.setDescripcion(rs.getString("descripcion"));
                libro.setEjemplares(rs.getString("ejemplares"));
                libro.setStock(rs.getInt("stock"));
                libro.setAvailable(rs.getInt("available"));
                //Adherencia de los parametros a la lista:
                listalibros.add(libro);
            }
            //Cerrado de la comunicacion con la base de datos:
            rs.close();
            st.close();
        } catch (Exception e) {

        }
        return listalibros;
    }

    @Override
    public Libros getLibrobyID(int libroID) throws Exception {
        Libros libro = new Libros();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM libros WHERE id = ?;");
            st.setInt(1, libroID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                libro.setId(rs.getInt("id"));
                libro.setTitle(rs.getString("title"));
                libro.setfecha(rs.getString("fecha"));
                libro.setAuthor(rs.getString("author"));
                libro.setCategory(rs.getString("category"));
                libro.setEdit(rs.getString("edit"));
                libro.setLang(rs.getString("lang"));
                libro.setPages(rs.getString("pages"));
                libro.setDescripcion(rs.getString("descripcion"));
                libro.setEjemplares(rs.getString("ejemplares"));
                libro.setStock(rs.getInt("stock"));
                libro.setAvailable(rs.getInt("available"));
            }
            //Cerrado de la comunicacion con la base de datos:
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return libro;
    }

    @Override
    public void Eliminar(int libroID) throws Exception {
        //Uso del "try{..}..." para el posible manejo de errores en compilacion:
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM libros WHERE id = ?;");
            st.setInt(1, libroID);
            st.executeQuery();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}

// CHECKPOINT: Lunes, 17/02/2025 - 
// NOTA: Correccion del apartado de "Devoluciones.java", funcionalidad completa y corregida.
//       Continuar con la optimizacion del codigo para la mejora y produccion final.