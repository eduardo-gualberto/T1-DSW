<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.domain.Cliente" %>
<%@ page import="br.ufscar.dc.dsw.dao.ClientDAO" %>
<%	
	String nome = request.getParameter("nome");
	String cpf = request.getParameter("cpf");
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	String telefone = request.getParameter("telefone");
	String dataNasc = request.getParameter("dataNasc");
	String sexo = request.getParameter("sexo");
	
	ClientDAO cDAO = new ClientDAO();
	Cliente c = new Cliente(nome, cpf, email, senha, sexo, telefone, dataNasc);
	cDAO.create(c);
%>
<jsp:forward page="home.jsp"></jsp:forward>