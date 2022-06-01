package org.example.webservice.services;

import org.example.webservice.modelBDD.dao.Join;
import org.example.webservice.modelBDD.main.MySQLConnector;
import org.example.webservice.modelBDD.manager.impl.JoinManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SecondaryService {

//    public void insertarJugador(String nombre, String contraseña) {
//        try (Connection con = new MySQLConnector().getMySQLConnection()) {
//            new PlayerManagerImpl().Insert(con, nombre, contraseña);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public List<Join> ranking () throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
           return new JoinManagerImpl().findAll(con);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }


    public List<Join> rankingById (int id) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return new JoinManagerImpl().findById(con, id);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }

}


