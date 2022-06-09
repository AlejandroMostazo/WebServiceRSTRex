package org.example.webservice.services;

import org.example.webservice.modelBDD.dao.Player;
import org.example.webservice.modelBDD.main.MySQLConnector;
import org.example.webservice.modelBDD.manager.impl.PlayerManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;

public class InicioService {

    public void insertarJugador(String nombre, String contraseña, String email) {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            new PlayerManagerImpl().insert(con, nombre, contraseña, email);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//    public List<Player> buscarJugadores () throws SQLException, ClassNotFoundException {
//        try (Connection con = new MySQLConnector().getMySQLConnection()) {
//
//           return new PlayerManagerImpl().findAll(con);
//        } catch (SQLException | ClassNotFoundException e) {
//            throw e;
//        }
//    }

    public boolean validarJugador(String nombre, String contraseña) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
           return new PlayerManagerImpl().validatePlayer(con, nombre, contraseña) != null;
        }
    }

    public Player buscarJugadorByName (String nombre) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return new PlayerManagerImpl().findByName(con, nombre);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }

}


