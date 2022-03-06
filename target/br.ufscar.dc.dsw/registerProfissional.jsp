<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.domain.Profissional" %>
<%@ page import="br.ufscar.dc.dsw.dao.ProfissionalDAO" %>
<%	
	String nome = request.getParameter("nome");
	String cpf = request.getParameter("cpf");
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	String areaCon = request.getParameter("areaCon");
	String espec = request.getParameter("especialidade");
	String curriculo = "T";
	
	ProfissionalDAO pDAO = new ProfissionalDAO();
	Profissional p = new Profissional(nome, cpf, email, senha, areaCon, espec, curriculo);
	pDAO.create(p);
%>
<jsp:forward page="register.jsp">
	<jsp:param name="opcao" value="profissional"></jsp:param>
	<jsp:param name="admin" value="T"></jsp:param>
	<jsp:param name="type" value="A"></jsp:param>
</jsp:forward>