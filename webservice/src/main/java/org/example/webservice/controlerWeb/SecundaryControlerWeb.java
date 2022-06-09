package org.example.webservice.controlerWeb;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


import org.example.webservice.modelBDD.dao.Join;
import org.example.webservice.services.SecondaryService;

import java.sql.SQLException;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("table")
public class SecundaryControlerWeb {

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
    @Path("/ranking")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Join> rankingMundial() throws SQLException, ClassNotFoundException {
        return new SecondaryService().ranking();
    }

    @GET
    @Path("/rankingId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Join> rankingPersonal(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        return new SecondaryService().rankingById(id);
    }

}
