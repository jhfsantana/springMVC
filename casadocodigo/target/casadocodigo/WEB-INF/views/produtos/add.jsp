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
    <form action="save" method="POST">
        <div>
            <label for="titulo">Titulo</label>
            <input type="text" name="titulo" id="titulo">
        </div>
        <div>
            <label for="descricao">Descricao</label>
            <textarea cols="20" rows="10" name="descricao" id="descricao"></textarea>
        </div>
        <div>
            <label for="paginas">Paginas</label>
            <input type="text" name="paginas" id="paginas">
        </div>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
