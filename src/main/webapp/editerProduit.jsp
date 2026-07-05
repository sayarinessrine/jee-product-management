<%@ page import="com.example.models.Produit" %>
<%@ page import="com.example.models.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <title>Insert title here</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #F5F5DC;"class="p-3 mb-2">
<%@include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Modification des Produits
        </div>
        <div class="card-body">
            <form action="EditerProduitServlet" method="post">
                <div hidden class="form-group">
                    <label class="control-label">ID Produit :</label>
                    <input type="text" name="id" class="form-control" value="${produit.getId()}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Nom Produit :</label>
                    <input type="text" name="nom" class="form-control" value="${produit.getNom()}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="text" name="prix" class="form-control" value="${produit.getPrix()}"/>
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
                <div>
                    <button type="submit" class="btn btn-primary">Modifier</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>