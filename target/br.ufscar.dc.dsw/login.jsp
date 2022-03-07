<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.controller.LogInController" %>
<%@ page import="br.ufscar.dc.dsw.dao.PessoaDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.ClientDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Cliente" %>
<%@ page import="br.ufscar.dc.dsw.dao.ProfissionalDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Profissional" %>
<%@ page import="java.util.List" %>
<%
	String usuario = request.getParameter("usuario");
	String senha = request.getParameter("senha");
	String type;
	//checa se é cliente ou profissional
	ClientDAO cDAO = new ClientDAO();
	List<Cliente> c = cDAO.findByEmailCliente(usuario);
	ProfissionalDAO pDAO = new ProfissionalDAO();
	List<Profissional> p = pDAO.findByEmailProfissional(usuario);
	if(!c.isEmpty()){
		type = "C";
	} if(!p.isEmpty()){
		type = "P";
	} else {
		type = "A";
	}

	if(LogInController.auth(usuario, senha) == 2) {
%>
		<jsp:forward page="home.jsp">
    		<jsp:param name="email" value="<%=usuario %>" />
    		<jsp:param name="admin" value="T" />
    		<jsp:param name="type" value="<%=type%>" />
		</jsp:forward>
<% } else if(LogInController.auth(usuario, senha) == 1){ %>
		<jsp:forward page="home.jsp">
    		<jsp:param name="email" value="<%=usuario %>" />
    		<jsp:param name="admin" value="F" />
    		<jsp:param name="type" value="<%=type%>" />
		</jsp:forward>				
<% } else { %>
		<jsp:forward page="index.jsp" />
<% } %>