package org.example.webservice.modelBDD.manager;



import org.example.webservice.modelBDD.dao.Join;

import java.sql.Connection;
import java.util.List;


public interface JoinMaganager {

    public List<Join> findAll(Connection con);

    public List<Join> findById(Connection con, int id);

}
