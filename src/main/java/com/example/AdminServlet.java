package com.example;

import java.io.*;
import java.sql.SQLException;

import com.example.models.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AdminServlet", value = "/login")
public class AdminServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        //response.setContentType("text/html");
       // PrintWriter pr = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Database database = new Database();
            database.connect();
            boolean auth = database.verifier(email, password);
            if (auth) {
                HttpSession session = request.getSession(true);
                session.setAttribute("userLoggedIn", true);
                Cookie loginCookie = new Cookie("userLoggedIn", "true");
                loginCookie.setMaxAge(60 * 60 * 24);

                response.addCookie(loginCookie);
                response.sendRedirect("SelectProdServlet");
               // request.getRequestDispatcher("SelectProdServlet").forward(request, response);

            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException c) {
            throw new RuntimeException();
        } catch (SQLException se) {
            throw new RuntimeException();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userLoggedIn") != null) {
            response.sendRedirect("SelectProdServlet");
            return;
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userLoggedIn") && cookie.getValue().equals("true")) {
                    response.sendRedirect("SelectProdServlet");
                    return;
                }
            }
        }

        response.sendRedirect("login.jsp");
    }
    }