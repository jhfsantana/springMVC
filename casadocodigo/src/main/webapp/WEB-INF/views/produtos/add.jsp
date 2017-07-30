<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form:form action="${s:mvcUrl('PC#save').build()}" method="POST" commandName="produto" enctype="multipart/form-data">
        <div>
            <label for="titulo">Titulo</label>
            <form:input  path="titulo"/>
            <form:errors path="titulo"></form:errors>
        </div>
        <div>
            <label for="descricao">Descricao</label>
            <form:textarea cols="20" rows="10" path="descricao"></form:textarea>
            <form:errors path="descricao"></form:errors>

        </div>
        <div>
            <label for="paginas">Paginas</label>
            <form:input  path="paginas" />
            <form:errors path="paginas"></form:errors>

        </div>
        <div>
            <label for="dataLancamento">Data de Lancamento</label>
            <form:input  path="dataLancamento" />
            <form:errors path="dataLancamento"></form:errors>

        </div>
        <c:forEach items="${ tipos }" var="preco" varStatus="status">
            <div>
                <label for="precos">${ preco }</label>
                <form:input path="precos[${status.index}].valor" id="precos" />
                <form:input type="hidden" path="precos[${status.index}].tipo" value="${preco}" />
            </div>
        </c:forEach>
        <div>
            <label for="sumario">Data de Lancamento</label>
            <input  name="sumario" id="sumario" type="file">
        </div>
        <button type="submit">Cadastrar</button>
    </form:form>
</body>
</html>
