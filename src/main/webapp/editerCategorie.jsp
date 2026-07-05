<%--
  Created by IntelliJ IDEA.
  User: SIA
  Date: 12/05/2024
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.models.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Insert title here</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>

<body style="background-color: #F5F5DC;" class="p-3 mb-2">
<%@include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Modification des Produits
        </div>
        <div class="card-body">
            <form action="EditerCategorieServlet" method="post">
                <div hidden class="form-group">
                    <label class="control-label">ID Categorie :</label>
                    <input type="text" name="id" class="form-control" value="${categorie.getId()}"/>
                </div>
                <div class="form-group">
                    <label class="control-label"> Date :</label>
                    <input type="date" name="date" class="form-control" value="${categorie.getDate()}"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Nom Categorie:</label>
                    <input type="text" name="nomcat" class="form-control" value="${categorie.getNomcat()}"/>
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

