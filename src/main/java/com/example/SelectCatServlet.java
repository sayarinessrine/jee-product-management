package com.example;

import com.example.models.Database;
import com.example.models.Categorie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name ="SelectCatServlet",value = "/SelectCatServlet")
public class SelectCatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Categorie> cat = null;
        try {
            Database db = new Database();
            db.connect();
            cat = db.selectCat();
            request.setAttribute("cat", cat);
            request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);

        }catch (ClassNotFoundException c){
            throw new RuntimeException();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
