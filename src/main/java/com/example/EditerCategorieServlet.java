package com.example;

import com.example.models.Categorie;
import com.example.models.Database;
import com.example.models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditerCategorieServlet",value = "/EditerCategorieServlet")
public class EditerCategorieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Database db = new Database();
            db.connect();
            Categorie categorie=db.selectCategorietById(id);
            request.setAttribute("categorie", categorie);
            request.getRequestDispatcher("editerCategorie.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nomcat = request.getParameter("nomcat");
        Date date=Date.valueOf(request.getParameter("date"));
        Categorie categorie = new Categorie(id, nomcat, date);
        try {
            Database db = new Database();
            db.connect();

            // Mettre à jour le produit dans la base de données
            db.updateCat(categorie);

            // Rediriger vers une autre page ou afficher un message de succès
            response.sendRedirect("SelectCategServlet");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Gérer l'erreur selon les besoins
        }
    }

}
