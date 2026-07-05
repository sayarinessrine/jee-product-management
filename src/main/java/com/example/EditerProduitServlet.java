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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditerProduitServlet",value = "/EditerProduitServlet")
public class EditerProduitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Categorie> cat = null;
        try {
            Database db = new Database();
            db.connect();
            cat = db.selectCat();
            request.setAttribute("cat", cat);
            Produit produit = db.selectProduitById(id);
            request.setAttribute("produit", produit);
            request.getRequestDispatcher("editerProduit.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Gérer l'erreur selon les besoins
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int idcat = Integer.parseInt(request.getParameter("categorie"));
        Produit produit = new Produit(id, nom, prix,idcat);
        try {
            Database db = new Database();
            db.connect();

            // Mettre à jour le produit dans la base de données
            db.updateProd(produit);

            // Rediriger vers une autre page ou afficher un message de succès
            response.sendRedirect("SelectProdServlet");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Gérer l'erreur selon les besoins
        }
    }
}