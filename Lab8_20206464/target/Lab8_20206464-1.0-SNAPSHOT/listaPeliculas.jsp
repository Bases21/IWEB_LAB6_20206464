<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Películas</title>
        <script type="text/javascript">
            function confirmarEliminacion(idPelicula) {
                if (confirm("¿Estás seguro de que deseas eliminar esta película?")) {
                    window.location.href = 'listaPeliculas?action=borrar&idPelicula=' + idPelicula;
                }
            }
        </script>
    </head>
    <body>
        <h1>Lista de Películas</h1>
        <table border="1">
            <tr>
                <th>Título</th>
                <th>Director</th>
                <th>Año Publicación</th>
                <th>Rating</th>
                <th>BoxOffice</th>
                <th>Género</th>
                <th>Actores</th>
                <th>Accionable</th>
            </tr>
            <%
                java.util.List<com.example.lab8_20206464.Beans.Pelicula> listaPeliculas =
                        (java.util.List<com.example.lab8_20206464.Beans.Pelicula>) request.getAttribute("listaPeliculas");
                if (listaPeliculas != null) {
                    for (com.example.lab8_20206464.Beans.Pelicula pelicula : listaPeliculas) {
            %>
            <tr>
                <td>
                    <!-- Enlace para ver los detalles de la película en viewPelicula.jsp -->
                    <a href="detallesServlet?idPelicula=<%= pelicula.getIdPelicula() %>">
                        <%= pelicula.getTitulo() %>
                    </a>
                </td>
                <td><%= pelicula.getDirector() %></td>
                <td><%= pelicula.getAnoPublicacion() %></td>
                <td><%= pelicula.getRating() %></td>
                <td><%= pelicula.getBoxOffice() %></td>
                <td><%= pelicula.getIdGenero().getNombre() %></td>
                <td><a href="verActores?idPelicula=<%= pelicula.getIdPelicula() %>">Ver Actores</a></td>
                <td><a href="#" onclick="confirmarEliminacion(<%= pelicula.getIdPelicula() %>)">Borrar</a></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="8">No hay películas disponibles.</td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
