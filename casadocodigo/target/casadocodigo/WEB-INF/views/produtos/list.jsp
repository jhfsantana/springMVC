<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Isabela
  Date: 29/07/2017
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Livros de Java, PHP, Object-C, Groovy e muito mais</title>
</head>
<body>
    ${ success }
    <table>
        <tr>
            <td>Titulo</td>
            <td>Descricao</td>
            <td>Paginas</td>
        </tr>
        <c:forEach items="${ produtos }" var="produto">
            <tr>
                <td> <a href="${s:mvcUrl('PC#details').arg(0, produto.id).build()}">${produto.titulo}</a> </td>
                <td> ${produto.descricao} </td>
                <td> ${produto.paginas} </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
