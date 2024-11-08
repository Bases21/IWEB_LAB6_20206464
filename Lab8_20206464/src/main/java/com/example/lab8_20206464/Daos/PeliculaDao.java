package com.example.lab8_20206464.Daos;

import com.example.lab8_20206464.Beans.Genero;
import com.example.lab8_20206464.Beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDao extends BaseDao {
    public ArrayList<Pelicula> listarPeliculas() {
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        String sql = "SELECT A.idPelicula, A.titulo, A.director, A.anoPublicacion, A.rating, A.boxOffice, B.nombre AS genero " +
                "FROM pelicula AS A " +
                "INNER JOIN genero AS B ON A.idGenero = B.idGenero " +
                "ORDER BY A.rating DESC ";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pelicula movie = new Pelicula();
                Genero genero = new Genero();

                movie.setIdPelicula(rs.getInt(1));
                movie.setTitulo(rs.getString(2));
                movie.setDirector(rs.getString(3));
                movie.setAnoPublicacion(rs.getInt(4));
                movie.setRating(rs.getDouble(5));
                movie.setBoxOffice(rs.getDouble(6));

                genero.setNombre(rs.getString(7));
                movie.setIdGenero(genero);

                listaPeliculas.add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al listar las películas", e);
        }

        return listaPeliculas;
    }
    public Pelicula obtenerPeliculaPorId(int idPelicula) {
        Pelicula pelicula = null;
        String sql = "SELECT A.idPelicula, A.titulo, A.director, A.anoPublicacion, A.rating, A.boxOffice, B.nombre AS genero " +
                "FROM pelicula AS A " +
                "INNER JOIN genero AS B ON A.idGenero = B.idGenero " +
                "WHERE A.idPelicula = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPelicula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pelicula = new Pelicula();
                    Genero genero = new Genero();

                    pelicula.setIdPelicula(rs.getInt("idPelicula"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                    pelicula.setRating(rs.getDouble("rating"));
                    pelicula.setBoxOffice(rs.getDouble("boxOffice"));

                    genero.setNombre(rs.getString("genero"));
                    pelicula.setIdGenero(genero);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los detalles de la película", e);
        }

        return pelicula;
    }
    public void eliminarPelicula(int idPelicula) {
        String sqlDeleteProtagonistas = "DELETE FROM protagonistas WHERE idPelicula = ?";

        String sqlDeletePelicula = "DELETE FROM pelicula WHERE idPelicula = ?";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmt1 = conn.prepareStatement(sqlDeleteProtagonistas)) {
                pstmt1.setInt(1, idPelicula);
                pstmt1.executeUpdate();
            }

            try (PreparedStatement pstmt2 = conn.prepareStatement(sqlDeletePelicula)) {
                pstmt2.setInt(1, idPelicula);
                pstmt2.executeUpdate();
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la película y sus referencias", e);
        }
    }

}