<%@ page import="java.util.List" %>
<%@ page import="com.example.models.Produit" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Produit</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #F5F5DC;"class="p-3 mb-2">
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">
            <p class="text-center">Nombre de produits : <%= request.getAttribute("np") %></p>
        </div>
        <div class="col">
            <p class="text-center">Nombre de catégories : <%= request.getAttribute("nc") %></p>
        </div>
        <div class="col">
            <p class="text-center">Prix maximal : <%= request.getAttribute("mxp") %></p>
        </div>
        <div class="col">
            <p class="text-center">Prix minimal : <%= request.getAttribute("mip") %></p>
        </div>
    </div>
</div>
<br>


<div class="card">
  <div class="card-header">
    Liste des Produits
  </div>
  <div class="card-body">

              <br>

      <table class="table table-striped">
        <tr>
          <th>ID</th><th>Nom Produit</th><th>Prix</th><th>Catégorie</th><th>Suppression</th><th>Edition</th>
         </tr>
<% List<Produit>l=(List<Produit>) request.getAttribute("l");
if(l!=null){
    for (Produit p:l){
%>
          <tr><td><%=p.getId()%></td><td><%=p.getNom()%></td><td><%=p.getPrix()%></td><td><%=p.getNomcat()%></td>
              <td><a href="SupprimerProduitServlet?id=<%= p.getId() %>" style="text-decoration: none; color: #8a2be2;">Supprimer</a></td>
              <td><a href="EditerProduitServlet?id=<%= p.getId() %>" style="text-decoration: none; color: #8a2be2;">Editer</a></td>
          </tr><%
    }}%>
    </table>
  </div>
</div>
<br>



</div>

</body>
</html>
