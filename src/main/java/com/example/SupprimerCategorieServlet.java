package com.example;

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

@WebServlet(name = "SupprimerCategorieServlet",value = "/SupprimerCategorieServlet")
public class SupprimerCategorieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {

            Database db = new Database();
            db.connect();
            List<Produit> produitsLies = db.getProduitsByCategorieId(id);

            // 2. Supprimer les produits liés
            for (Produit produit : produitsLies) {
                db.supprimerProduit(produit.getId());
            }
            db.supprimerCat(id);
            // Rediriger vers la page principale ou une autre page après la suppression
            response.sendRedirect("SelectCategServlet");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Gérer l'erreur selon les besoins
        }
    }
}
