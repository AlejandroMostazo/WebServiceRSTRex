package org.example.webservice.controlerWeb;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.webservice.modelBDD.dao.Player;
import org.example.webservice.services.InicioService;

import java.awt.geom.RectangularShape;
import java.sql.SQLException;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("inicio")
public class InicioControlerWeb {

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPlayer(Player player) {
        new InicioService().insertarJugador(player.getName(), player.getContraseña());
        return Response.status(201).build();
    }

    @POST
    @Path("/validar")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean checkPlayer(Player player) throws SQLException, ClassNotFoundException {
        return new InicioService().validarJugador(player.getName(), player.getContraseña());
    }

    @GET
    @Path("/search/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player searchPlayer(@PathParam("nombre") String name) throws SQLException, ClassNotFoundException {
        return new InicioService().buscarJugadorByName(name);
    }

}
