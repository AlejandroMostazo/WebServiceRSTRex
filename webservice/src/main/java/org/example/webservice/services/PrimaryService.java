package org.example.webservice.services;


import org.example.webservice.modelBDD.main.MySQLConnector;
import org.example.webservice.modelBDD.manager.impl.ScoreManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class PrimaryService {

    public void insertarPuntuacion(int puntuacion, LocalDateTime fecha, int idplayer) {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            new ScoreManagerImpl().Insert(con, puntuacion, fecha, idplayer);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
