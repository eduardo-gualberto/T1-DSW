<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.domain.Consulta" %>
<%@ page import="br.ufscar.dc.dsw.dao.ConsultaDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.PessoaDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pessoa" %>
<%@ page import="java.util.List" %>
<%
	String cpf_pro = request.getParameter("cpf_pro");
	String cpf_cli = request.getParameter("cpf_cli");
	String data_hora = request.getParameter("data_hora");
	String email = (String)session.getAttribute("email");
	ConsultaDAO cDAO = new ConsultaDAO();
	Consulta consulta = new Consulta(data_hora, cpf_pro, cpf_cli);
	cDAO.create(consulta);
%>
<jsp:forward page="home.jsp">
	<jsp:param name="admin" value="F"></jsp:param>
	<jsp:param name="type" value="C"></jsp:param>
	<jsp:param name="email" value="<%=email%>"></jsp:param>
</jsp:forward>