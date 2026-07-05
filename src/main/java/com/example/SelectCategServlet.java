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

@WebServlet(name = "SelectCategServlet",value = "/SelectCategServlet")
public class SelectCategServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            List<Categorie> l=null;
            Database db=new Database();
            db.connect();
            int np=db.countProduits();
            int nc=db.countCategorie();
            request.setAttribute("np",np);
            request.setAttribute("nc",nc);
            l=db.selectCat();
            request.setAttribute("l",l);
            request.getRequestDispatcher("categories.jsp").forward(request, response);
        }catch (ClassNotFoundException e){
            throw new RuntimeException();
        }catch (SQLException c){
            c.printStackTrace();
        }

    }
}
