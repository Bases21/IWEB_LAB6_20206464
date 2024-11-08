package com.example.lab8_20206464.Daos;

import com.example.lab8_20206464.Beans.Actor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDao extends BaseDao {

    public List<Actor> obtenerActoresPorPelicula(int idPelicula) {
        List<Actor> listaActores = new ArrayList<>();
        String sql = "SELECT a.idActor, a.Nombre, a.Apellido, a.anoNacimiento, a.premioOscar " +
                "FROM actor a " +
                "INNER JOIN protagonistas p ON a.idActor = p.idActor " +
                "WHERE p.idPelicula = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Actor actor = new Actor();
                    actor.setIdActor(rs.getInt("idActor"));
                    actor.setNombre(rs.getString("Nombre"));
                    actor.setApellido(rs.getString("Apellido"));
                    actor.setAnoNacimiento(rs.getInt("anoNacimiento"));
                    actor.setPremioOscar(rs.getInt("premioOscar"));

                    listaActores.add(actor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los actores de la película", e);
        }

        return listaActores;
    }

    public String obtenerTituloPelicula(int idPelicula) {
        String titulo = null;
        String sql = "SELECT titulo FROM pelicula WHERE idPelicula = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    titulo = rs.getString("titulo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el título de la película", e);
        }

        return titulo;
    }
}
