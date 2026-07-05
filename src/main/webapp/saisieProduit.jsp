<%@ page import="com.example.models.Database" %>
<%@ page import="com.example.models.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
<title>Saisie Produits</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #F5F5DC;"class="p-3 mb-5">
<%@include file="header.jsp" %>

<div class="container mt-5">
<div class="card">
  <div class="card-header">
    Saisie des Produits
  </div>
  <div class="card-body">
      <form action="InsertProdServlet" method="get">

      <div class="form-group mb-4">
       <label class="control-label">Nom Produit :</label>
       <input type="text" name="nom" class="form-control"/>
      </div>
      <div class="form-group mb-4">
       <label class="control-label">Prix :</label>
       <input type="text" name="prix" class="form-control"/>
      </div>

              <div class="form-group mb-5">
                  <select name="categorie" class="form-control">

                      <%
                          List<Categorie> categoriesList = (List<Categorie>)request.getAttribute("cat");

                          for (Categorie cat : categoriesList) {
                      %>
                              <option value="<%= cat.getId() %>"><%= cat.getNomcat() %></option>
                      <%

                          }
                      %>
                  </select>
              </div>

      <div class="mt-5 mb-0">
        <button type="submit" class="btn btn-primary"style="background: #8a2be2;">Ajouter</button>
      </div>
      </form>

  </div>
</div>
</div>
</body>
</html>
