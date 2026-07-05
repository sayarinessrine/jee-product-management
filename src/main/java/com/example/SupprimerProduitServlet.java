package com.example;

import com.example.models.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SupprimerProduitServlet",value = "/SupprimerProduitServlet")
public class SupprimerProduitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            // Supprimer le produit de la base de données en fonction de l'ID
            Database db = new Database();
            db.connect();
            db.supprimerProduit(id);
            // Rediriger vers la page principale ou une autre page après la suppression
            response.sendRedirect("SelectProdServlet");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Gérer l'erreur selon les besoins
        }
    }
}
