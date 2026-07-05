<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Saisie Catégorie</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background-color: #F5F5DC;"class="p-3 mb-2">
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Saisie des Catégories
  </div>
  <div class="card-body">
      <form action="save" method="get">
      <div class="form-group">
       <label class="control-label">Nom Catégorie :</label>
       <input type="text" name="nom" class="form-control">
      </div>   
      <div class="form-group">
       <label class="control-label">Date Catégorie :  </label>   
           <input  type="date" name="dateCat" class="form-control">
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
