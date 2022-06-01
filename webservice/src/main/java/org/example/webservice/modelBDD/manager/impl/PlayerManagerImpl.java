package org.example.webservice.modelBDD.manager.impl;



import org.example.webservice.modelBDD.dao.Player;
import org.example.webservice.modelBDD.manager.PlayerMaganager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * City DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Cities data.
 *
 * @author jose.m.prieto.villar
 *
 */

public class PlayerManagerImpl implements PlayerMaganager {

    public List<Player> findAll(Connection con) {
        // Create general statement
        try (Statement stmt = con.createStatement()) {
            // Queries the DB
            ResultSet result = stmt.executeQuery("SELECT * FROM juego.player order by 3");
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            List<Player> players = new ArrayList<>();

            // Run through each result
            while (result.next()) {
                // Initializes a city per result
                players.add(new Player(result));
                // Groups the countried by city
            }
            return players;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public City findById(Connection con, int id) {
//        //prepare SQL statement
//        String sql = "select * "
//                + "from city a, Country b "
//                + "where a.id = ? "
//                + "and a.CountryCode = b.Code";
//
//        // Create general statement
//        try (PreparedStatement stmt = con.prepareStatement(sql)) {
//            //Add Parameters
//            stmt.setInt(1, id);
//            // Queries the DB
//            ResultSet result = stmt.executeQuery();
//            // Set before first registry before going through it.
//            result.beforeFirst();
//
//            // Initialize variable
//            City city = null;
//
//            // Run through each result
//            while (result.next()) {
//                // Initializes a city per result
//                city = new City(result);
//                Country country = new Country(result);
//                city.setCountry(country);
//            }
//
//            return city;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
    public Player findByName(Connection con, String name) {
        //prepare SQL statement
        String sql = "select * "
                + "from juego.player "
                + "where nombre = ? order by 2";

        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            //Add Parameters
            stmt.setString(1, name);
            // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            Player player = null;

            // Run through each result
            while (result.next()) {
                // Initializes a city per result
                player = new Player(result);
            }

            return player;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Player validatePlayer(Connection con, String name, String contraseña) {



        //prepare SQL statement
        String sql = "select * "
                + "from juego.player "
                + "where nombre = ? and contraseña = ?";

        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            //Add Parameters
            stmt.setString(1, name);
            stmt.setString(2, contraseña);
            // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            Player player = null;

            // Run through each result
            while (result.next()) {
                // Initializes a city per result
                player = new Player(result);
            }

            return player;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



//
//    public City endLetter(Connection con, String end) {
//        //prepare SQL statement
//        String sql = "select * "
//                + "from city a, Country b "
//                + "where a.Name LIKE ? "
//                + "and a.CountryCode = b.Code";
//
//        // Create general statement
//
//        try (PreparedStatement stmt = con.prepareStatement(sql)) {
//            //Add Parameters
//            stmt.setString(1, '%'+end);
//            // Queries the DB
//            ResultSet result = stmt.executeQuery();
//            // Set before first registry before going through it.
//            result.beforeFirst();
//
//            // Initialize variable
//            City city = null;
//
//            // Run through each result
//            while (result.next()) {
//                // Initializes a city per result
//                city = new City(result);
//                Country country = new Country(result);
//                city.setCountry(country);
//            }
//
//            return city;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public List<City> frist(Connection con, String fristLetter) {
//        //prepare SQL statement
//        String sql = "select * "
//                + "from city a, Country b "
//                + "where a.Name LIKE ? "
//                + "and a.CountryCode = b.Code";
//
//        // Create general statement
//
//        try (PreparedStatement stmt = con.prepareStatement(sql)) {
//            //Add Parameters
//            stmt.setString(1, fristLetter+'%');
//            // Queries the DB
//            ResultSet result = stmt.executeQuery();
//            // Set before first registry before going through it.
//            result.beforeFirst();
//
//            // Initialize variable
//            City city = null;
//            List<City> ciudades = new ArrayList<>();
//            // Run through each result
//            while (result.next()) {
//                // Initializes a city per result
//                city = new City(result);
//                Country country = new Country(result);
//                city.setCountry(country);
//                ciudades.add(city);
//            }
//
//            return ciudades;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void Delete(Connection con, int id) {
//
//        String sql = ("DELETE FROM city WHERE id = "+id);
//        //prepare SQL statement
//        try(PreparedStatement st = con.prepareStatement(sql)) {
//
//
//            //Set before first registry before going through it.
//            st.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
    public void insert(Connection con, String nombre, String contraseña) {

            String sql = ("INSERT INTO juego.player (nombre, contraseña) VALUE(?, ?)");
            //prepare SQL statement
            try(PreparedStatement st = con.prepareStatement(sql)) {

                st.setString(1, nombre);
                st.setString(2, contraseña);

                //Set before first registry before going through it.
                st.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
//
//    public void Upade(Connection con, int puntuacion, int id) {
//        //prepare SQL statement
//
//        String sql = "UPDATE juego.player a SET puntuacion = ? where id = ?";
//        try(PreparedStatement st = con.prepareStatement(sql)) {
//            // Queries the DB
//            st.setInt(1, puntuacion);
//            st.setInt(2, id);
//            // Set before first registry before going through it.
//            st.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Fills all the countries for each city.
     *
     * @param con       the Db connection
     * @param countries the map of cities and countries.
     * @param cities    the list of cities to update.
     */

}
