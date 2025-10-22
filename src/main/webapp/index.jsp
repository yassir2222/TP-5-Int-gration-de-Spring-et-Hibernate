<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Produits</title>
</head>
<body>
<h2>Produits</h2>
<table border="1" cellpadding="4" cellspacing="0">
    <tr><th>Id</th><th>Nom</th><th>Prix</th></tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td><c:out value="${p.id}"/></td>
            <td><c:out value="${p.name}"/></td>
            <td><c:out value="${p.price}"/></td>
        </tr>
    </c:forEach>
</table>

<h3>Ajouter un produit</h3>
<form method="post" action="${pageContext.request.contextPath}/products">
    <label>Nom: <input type="text" name="name" required /></label><br/>
    <label>Prix: <input type="number" step="0.01" name="price" /></label><br/>
    <button type="submit">Ajouter</button>
</form>
</body>
</html>