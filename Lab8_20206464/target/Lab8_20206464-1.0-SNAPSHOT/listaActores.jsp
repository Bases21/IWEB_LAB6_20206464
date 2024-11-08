<%@ page import="com.example.lab8_20206464.Beans.Actor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Actores de la Película</title>
    </head>
    <body>
        <h1>Actores de <%= request.getAttribute("tituloPelicula") %></h1>
        <table border="1">
            <tr>
                <th>idActor</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Año Nacimiento</th>
                <th>Ganador Premio Oscar</th>
            </tr>
            <%
                List<Actor> listaActores = (List<Actor>) request.getAttribute("listaActores");
                if (listaActores != null && !listaActores.isEmpty()) {
                    for (Actor actor : listaActores) {
            %>
            <tr>
                <td><%= actor.getIdActor() %></td>
                <td><%= actor.getNombre() %></td>
                <td><%= actor.getApellido() %></td>
                <td><%= actor.getAnoNacimiento() %></td>
                <td><%= actor.getPremioOscar() == 1 ? "true" : "false" %></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="5">No hay actores disponibles para esta película.</td>
            </tr>
            <%
                }
            %>
        </table>
        <button onclick="location.href='crearActor.jsp'">Crear Actor</button>
    </body>
</html>
