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

@WebServlet(name ="SelectProdServlet",value = "/SelectProdServlet")
public class SelectProdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try {
            List<Produit>l=null;
            Database db=new Database();
            db.connect();
            int np=db.countProduits();
            int nc=db.countCategorie();
            double mxp= db.calculerPrixMax();
            double mip= db.calculerPrixMin();
            request.setAttribute("np",np);
            request.setAttribute("nc",nc);
            request.setAttribute("mxp",mxp);
            request.setAttribute("mip",mip);
            l=db.selectProd();
            request.setAttribute("l",l);
            request.getRequestDispatcher("produits.jsp").forward(request, response);
        }catch (ClassNotFoundException e){
            throw new RuntimeException();
        }catch (SQLException c){
            c.printStackTrace();
        }

    }
}
