package org.example.webservice.controlerWeb;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.webservice.controlerWeb.dto.Email;
import org.example.webservice.email.Sender;
import org.example.webservice.modelBDD.dao.Join;
import org.example.webservice.services.EmailService;
import org.example.webservice.services.SecondaryService;

import java.sql.SQLException;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("email")
public class EmailControlerWeb {

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
    public Response enviarEmail(Email email) {
        new EmailService().sendEmail(email.getEmail(), email.getNombre());
        return Response.status(201).build();
    }


    @POST
    @Path("/sendRanking")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendRanking(Email email) throws SQLException, ClassNotFoundException {
        new EmailService().sendRanking(email.getEmail(), email.getId());
        return Response.status(201).build();
    }

}
