package com.example.lab8_20206464.Servlets;

import com.example.lab8_20206464.Beans.Pelicula;
import com.example.lab8_20206464.Daos.PeliculaDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "detallesServlet", urlPatterns = {"/detallesServlet"})
public class detallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));

        PeliculaDao peliculaDao = new PeliculaDao();
        Pelicula pelicula = peliculaDao.obtenerPeliculaPorId(idPelicula);

        request.setAttribute("pelicula", pelicula);

        request.getRequestDispatcher("/viewPelicula.jsp").forward(request, response);

    }
}

