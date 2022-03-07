<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.domain.Cliente" %>
<%@ page import="br.ufscar.dc.dsw.dao.ClientDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Profissional" %>
<%@ page import="br.ufscar.dc.dsw.dao.ProfissionalDAO" %>
<%
	String admin = request.getParameter("admin");
	String type = request.getParameter("type");
	String email = request.getParameter("email");
	session.setAttribute("email", email);
%>
<% if(admin.equals("T")){ %>
<form action="register.jsp" method="POST">
        <fieldset>
            <legend>Registrar usuário</legend>
            Escolha apenas um:<br/>
            Cliente: <input type="checkbox" name="opcao" value="cliente"/><br/>
            Profissional: <input type="checkbox" name="opcao" value="profissional"/><br/>
            <input type="submit" value="Register" />
        </fieldset>
    </form>
<% } %>

<a href="listarProfissionais.jsp">Listar todos os profissionais cadastrados</a><br/><br/>
<a href="agendarConsulta.jsp">Agendar um horario com um profissional</a><br/><br/>
<a href="listarConsultas.jsp">Listar meus horários de consulta</a><br/>