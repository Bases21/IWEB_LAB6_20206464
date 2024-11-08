<%@ page import="com.example.lab8_20206464.Beans.Pelicula" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            <%
                Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
                if (pelicula != null) {
            %>Película <%= pelicula.getIdPelicula() %><%
        } else {
        %>Película no encontrada<%
            }
        %>
        </title>
    </head>
    <body>
        <h1>
            <% if (pelicula != null) { %>
            Película Número <%= pelicula.getIdPelicula() %>
            <% } else { %>
            Película no encontrada
            <% } %>
        </h1>

        <% if (pelicula != null) { %>
        <form method="post">
            <table border="1">
                <tr>
                    <td>Título</td>
                    <td><input type="text" name="titulo" value="<%= pelicula.getTitulo() %>" readonly></td>
                </tr>
                <tr>
                    <td>Director</td>
                    <td><input type="text" name="director" value="<%= pelicula.getDirector() %>" readonly></td>
                </tr>
                <tr>
                    <td>Año Publicación</td>
                    <td><input type="text" name="anoPublicacion" value="<%= pelicula.getAnoPublicacion() %>" readonly></td>
                </tr>
                <tr>
                    <td>Rating</td>
                    <td><input type="text" name="rating" value="<%= pelicula.getRating() %>" readonly></td>
                </tr>
                <tr>
                    <td>BoxOffice</td>
                    <td><input type="text" name="boxOffice" value="<%= pelicula.getBoxOffice() %>" readonly></td>
                </tr>
                <tr>
                    <td>Actores</td>
                    <td><a href="verActores?idPelicula=<%= pelicula.getIdPelicula() %>">Ver Actores</a></td>
                </tr>
            </table>
        </form>
        <% } else { %>
        <p>Error: Película no encontrada. Por favor, verifica el ID.</p>
        <% } %>
    </body>
</html>
