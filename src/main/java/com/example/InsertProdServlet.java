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

@WebServlet(name = "InsertProdServlet",value = "/InsertProdServlet")
public class InsertProdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        String nom=request.getParameter("nom");
        Double prix=Double.parseDouble(request.getParameter("prix"));
        Integer idcat=Integer.parseInt(request.getParameter("categorie"));
        try {
            Database db = new Database();
            db.connect();
            Produit p = new Produit(nom,prix,idcat);
            db.insertProd(p);
            response.sendRedirect("SelectProdServlet");
        }catch (ClassNotFoundException c){
            throw new RuntimeException();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
