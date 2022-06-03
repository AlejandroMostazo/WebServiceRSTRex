package org.example.webservice.controlerWeb;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.webservice.modelBDD.dao.Player;
import org.example.webservice.services.InicioService;

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
    @Path("/insertar/{nombre}/{contraseña}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertPlayer(@PathParam("nombre") String name, @PathParam("contraseña") String pass) {
        new InicioService().insertarJugador(name, pass);
    }

    @GET
    @Path("/validar/{nombre}/{contraseña}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean checkPlayer(@PathParam("nombre") String name, @PathParam("contraseña") String pass) throws SQLException, ClassNotFoundException {
        return new InicioService().validarJugador(name, pass);
    }

    @GET
    @Path("/search/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player searchPlayer(@PathParam("nombre") String name) throws SQLException, ClassNotFoundException {
        return new InicioService().buscarJugadorByName(name);
    }

}
