<%@ page import="jakarta.servlet.http.Cookie, jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse, jakarta.servlet.http.HttpSession" %>

<%

  HttpSession sessio = request.getSession(false);

  if (sessio == null || sessio.getAttribute("userLoggedIn") == null) {

    boolean cookieUserLoggedInNull = true;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("userLoggedIn") && cookie.getValue().equals("true")) {
          cookieUserLoggedInNull = false;
          break;
        }
      }
    }

    if (cookieUserLoggedInNull) {
      response.sendRedirect("login.jsp");
      return;
    }
  }
%>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #8a2be2;">
  <div class="collapse navbar-collapse justify-content-center " id="navbarNav"  >  
    <ul class="navbar-nav">

      <li class="nav-item">
        <a class="nav-link" href="SelectProdServlet">Produits</a>
      </li>
      <li class="nav-item ">
  		<a class="nav-link" href="SelectCategServlet">Categories</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="SelectCatServlet">Saisie Produit</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="saisieCategorie.jsp" >Saisie Categorie</a>
      </li>
      <li class="nav-item" style="margin-left:300px;">
        <a class="nav-link" href="logoutServlet">Logout</a>
      </li>
      

      
     </ul>
    
  </div>
</nav>
<br>