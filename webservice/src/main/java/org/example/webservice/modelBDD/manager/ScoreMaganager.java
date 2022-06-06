package org.example.webservice.modelBDD.manager;



import org.example.webservice.modelBDD.dao.Score;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

public interface ScoreMaganager {

    public List<Score> findAll(Connection con);

    public void Insert(Connection con, int puntuacion, int idplayer);
}
