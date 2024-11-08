package com.example.lab8_20206464.Servlets;

import com.example.lab8_20206464.Beans.Pelicula;
import com.example.lab8_20206464.Daos.PeliculaDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PeliculaServlet", urlPatterns = {"/listaPeliculas"})
public class PeliculaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PeliculaDao peliculaDao = new PeliculaDao();

        String action = request.getParameter("action");

        if ("listar".equals(action)) {
            ArrayList<Pelicula> listaPeliculas = peliculaDao.listarPeliculas();
            request.setAttribute("listaPeliculas", listaPeliculas);
            request.getRequestDispatcher("listaPeliculas.jsp").forward(request, response);
        } else if ("borrar".equals(action)) {
            int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
            peliculaDao.eliminarPelicula(idPelicula);
            response.sendRedirect("listaPeliculas?action=listar"); // Redirige a la lista de películas
        }
    }
}
