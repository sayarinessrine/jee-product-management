package com.example;

import com.example.models.Categorie;
import com.example.models.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name ="a",value ="/save")
public class InsertCatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        String nom=request.getParameter("nom");
        Date date=Date.valueOf(request.getParameter("dateCat"));
       // Integer id=Integer.parseInt(request.getParameter("id"));
        try {
            Database db = new Database();
            db.connect();
            Categorie c = new Categorie(nom,date);
            db.insertCat(c);

            response.sendRedirect("SelectCategServlet");
        }catch (ClassNotFoundException c){
            throw new RuntimeException();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
