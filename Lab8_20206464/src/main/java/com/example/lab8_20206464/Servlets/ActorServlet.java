package com.example.lab8_20206464.Servlets;

import com.example.lab8_20206464.Beans.Actor;
import com.example.lab8_20206464.Daos.ActorDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ActorServlet", urlPatterns = {"/verActores"})
public class ActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));

        ActorDao actorDao = new ActorDao();
        List<Actor> listaActores = actorDao.obtenerActoresPorPelicula(idPelicula);

        request.setAttribute("listaActores", listaActores);
        request.setAttribute("tituloPelicula", actorDao.obtenerTituloPelicula(idPelicula));

        request.getRequestDispatcher("/listaActores.jsp").forward(request, response);
    }
}
