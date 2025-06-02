/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
//Importaciones de generales para el facil acceso a metodos y atributos:

import DataBase_Models.*;
import Interfaces.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabrizio
 */
public class DAOUsuariosImpl extends DataBase.database implements DAOUsuarios {

    @Override
    public void Registrar(Usuarios usuario) throws Exception {
        //Uso del "try" para el manejo de posibles errores:
        try {
            //Comunicacion con la base de datos:
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Usuarios(name,last_name_p,last_name_m,domicilio,tel) VALUES (?,?,?,?,?);");
            st.setString(1, usuario.getName());
            st.setString(2, usuario.getLast_name_p());
            st.setString(3, usuario.getLast_name_m());
            st.setString(4, usuario.getDomicilio());
            st.setString(5, usuario.getTel());

            //Eejcutado y corte de la comunicacion con la base de datos:
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void Modificar(Usuarios usuario) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Usuarios SET name = ?, last_name_p = ?, last_name_m = ?, domicilio = ?, tel = ? WHERE id = ?;");
            st.setString(1, usuario.getName());
            st.setString(2, usuario.getLast_name_p());
            st.setString(3, usuario.getLast_name_m());
            st.setString(4, usuario.getDomicilio());
            st.setString(5, usuario.getTel());
            //Valor de ID a editar (Tambien sirve como identificador):
            st.setInt(6, usuario.getId());
            //Eejcutado y corte de la comunicacion con la base de datos:
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void Eliminar(int usuarioID) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Usuarios WHERE id = ?;");
            st.setInt(1, usuarioID);
            //Eejcutado y corte de la comunicacion con la base de datos:
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Usuarios> Listar(String nombre) throws Exception {
        //Inicializacion del vector tipo lista con valor inicial "null":
        List<Usuarios> lista = null;
        //Uso del metodo "try" para el manejo de posibles errores de compilacion:
        try {
            //Comunicacion con la base de datos:
            this.Conectar();

            //Condicion adaptativa de consulta con la base de datos:
            String Query = nombre.isEmpty() ? "SELECT * FROM Usuarios;" : "SELECT * FROM Usuarios WHERE name LIKE '%" + nombre + "%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                //Instanciaciond de los usuarios:
                Usuarios usuario = new Usuarios();

                //Solicitud de los parametros consultados:
                usuario.setId(rs.getInt("id"));
                usuario.setName(rs.getString("name"));
                usuario.setLast_name_p(rs.getString("last_name_p"));
                usuario.setLast_name_m(rs.getString("last_name_m"));
                usuario.setDomicilio(rs.getString("domicilio"));
                usuario.setTel(rs.getString("tel"));
                usuario.setSanctions(rs.getInt("sanctions"));
                usuario.setSanc_money(rs.getInt("sanc_money"));

                //Adherencia de los parametros a la lista:
                lista.add(usuario);
            }
            //Cerrado de la comunicacion con la base de datos:
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Usuarios getUsuarioByID(int usuarioID) throws Exception {
        Usuarios usuario = new Usuarios();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Usuarios WHERE id = ?;");
            //Parametro de lectura: id = 1 (y proximos)
            st.setInt(1, usuarioID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //Solicitud de los parametros consultados:
                usuario.setId(rs.getInt("id"));
                usuario.setName(rs.getString("name"));
                usuario.setLast_name_p(rs.getString("last_name_p"));
                usuario.setLast_name_m(rs.getString("last_name_m"));
                usuario.setDomicilio(rs.getString("domicilio"));
                usuario.setTel(rs.getString("tel"));
                usuario.setSanctions(rs.getInt("sanctions"));
                usuario.setSanc_money(rs.getInt("sanc_money"));
            }
            //Cerrado de la comunicacion con la base de datos:
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return usuario;
    }

    @Override
    public void sancionar(Usuarios usuario) throws Exception {
        //Accionamiento del sancionamiento de usuario:
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE usuarios SET sanctions = ?, sanc_money = ? WHERE id = ?");
            //Parametrizacion:
            st.setInt(1, usuario.getSanctions());
            st.setInt(2, usuario.getSanc_money());
            st.setInt(3, usuario.getId());
            //Ejecucion y cierre de conexion:
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
