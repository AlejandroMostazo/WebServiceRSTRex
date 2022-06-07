package org.example.webservice.controlerWeb;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.webservice.email.Sender;
import org.example.webservice.modelBDD.dao.Join;
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
    public Response enviarEmail(String email, String nombre) {
        new Sender().send("alejandro.mostazo.fp@iescampanillas.com", email, "Tu cuenta ha sido creada con éxito",
                "<b>Ahora podrás saltar todos los cactus que quieras iniciando sesión con el nombre de "+nombre+" y la contraseña " +
                        "que hayas indicao anteroirmente. </br>" +
                       "¡Diviertete! :D <b>");
        return Response.status(201).build();
    }


    @POST
    @Path("/sendRanking")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendRanking(String email, int id) throws SQLException, ClassNotFoundException {
        new Sender().send("alejandro.mostazo.fp@iescampanillas.com", email, "Registro de partidas T-Rex",
                "<b><table>" +
                        "<tr><th>Top</th>" +
                        "<th>Nombre</th>" +
                        "<th>Puntuacion</th>" +
                        "<th>Fecha</th>" +
                        "</tr>"
                        +obtenerRanking(id)+
                        "</table></br>" +
                        "¡Diviertete! :D <b>");
        return Response.status(201).build();
    }

    public String obtenerRanking (int id) throws SQLException, ClassNotFoundException {
       List<Join> list = new SecondaryService().rankingById(id);
       String tabla = "";
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 4; j++) {
                tabla = tabla+"<tr><td>"+list.get(1).getPuesto()+"</td>" +
                        "<td>"+list.get(1).getNombre()+"</td>" +
                        "<td>"+list.get(1).getPuntuacion()+"</td>" +
                        "<td>"+list.get(1).getFecha()+"</td>";
            }
            tabla = tabla+"</tr>";
        }
        return tabla;
    }

}
