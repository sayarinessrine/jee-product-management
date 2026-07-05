<%@ page import="com.example.models.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.models.Categorie" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des catégories</title>
</head>
<body>
<h1>Liste des catégories :</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <!-- Ajoutez d'autres colonnes si nécessaire -->
    </tr>
    <%
        List<Categorie> cat = (List<Categorie>)request.getAttribute("cat");
        if(cat != null) {
            for(Categorie categorie : cat) {
    %>
    <tr>
        <td><%= categorie.getId() %></td>
        <td><%= categorie.getNom() %></td>
        <!-- Remplacez "getId()" et "getNom()" par les méthodes d'accès à l'ID et au nom dans votre classe Categorie -->
        <!-- Ajoutez d'autres colonnes si nécessaire -->
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">Aucune catégorie trouvée</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>