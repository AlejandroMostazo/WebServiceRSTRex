package org.example.webservice.controlerWeb;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.webservice.services.InicioService;

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

}
