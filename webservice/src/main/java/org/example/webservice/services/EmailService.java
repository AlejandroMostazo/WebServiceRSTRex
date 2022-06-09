package org.example.webservice.services;


import org.example.webservice.email.Sender;
import org.example.webservice.modelBDD.dao.Join;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class EmailService {
    public void sendEmail(String email, String nombre) {
        new Sender().send("alejandro.mostazo.fp@iescampanillas.com", email, "Tu cuenta ha sido creada con éxito",
                "<b>Ahora podrás saltar todos los cactus que quieras iniciando sesión con el nombre de "+nombre+" y la contraseña " +
                        "que hayas indicao anteroirmente. </br>" +
                        "¡Diviertete! :D <b>");
    }

    public void sendRanking(String email, int id) throws SQLException, ClassNotFoundException {
        new Sender().send("alejandro.mostazo.fp@iescampanillas.com", email, "Registro de partidas T-Rex",
                        "<b><table style=\"border-collapse: collapse; text-align: center; width: 70%\">" +
                        "<tr><th style=\"border: 1px solid black\">Top</th>" +
                        "<th style=\"border: 1px solid black\">Nombre</th>" +
                        "<th style=\"border: 1px solid black\">Puntuacion</th>" +
                        "<th style=\"border: 1px solid black\">Fecha</th>" +
                        "</tr>"
                        +obtenerRanking(id)+
                        "</table></br>" +
                        "¡Diviertete! :D <b>");
    }

    public String obtenerRanking (int id) throws SQLException, ClassNotFoundException {
        List<Join> list = new SecondaryService().rankingById(id);
        AtomicReference<String> tabla = new AtomicReference<>("");
        IntStream.range(0, list.size()).forEach(i -> tabla.set(tabla + "<tr><td style=\"border: 1px solid black\">" + list.get(i).getPuesto() + "</td>" +
                "<td style=\"border: 1px solid black\">" + list.get(i).getNombre() + "</td>" +
                "<td style=\"border: 1px solid black\">" + list.get(i).getPuntuacion() + "</td>" +
                "<td style=\"border: 1px solid black\">" + list.get(i).getFecha() + "</td></tr>"));
        return tabla.get();
    }

}
