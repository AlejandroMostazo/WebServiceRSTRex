package org.example.webservice.controlerWeb;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import org.example.webservice.services.PrimaryService;


import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("game")
public class PrimaryControlerWeb {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }



    @GET
    @Path("/score/{puntuacion}/{fecha}/{idplayer}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertScore(@PathParam("puntuacion") int punt, @PathParam("fecha") Date fecha, @PathParam("idplayer") int id) throws SQLException, ClassNotFoundException {
         new PrimaryService().insertarPuntuacion(punt, fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), id);
    }


}