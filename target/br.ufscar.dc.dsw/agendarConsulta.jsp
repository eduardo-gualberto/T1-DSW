<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.domain.Consulta" %>
<%@ page import="br.ufscar.dc.dsw.dao.ConsultaDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.PessoaDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pessoa" %>
<%@ page import="java.util.List" %>
<%
	String email = (String)session.getAttribute("email");
	PessoaDAO pDAO = new PessoaDAO();
	List<Pessoa> p = pDAO.findByEmail(email);
	String cpf_cli = p.remove(0).getCpf();
%>

<form action="registerConsulta.jsp" method="POST">
    <fieldset>
        <legend>Registrar Consulta</legend>
        CPF Profissional: <input type="text" name="cpf_pro" /><br/>
        Data e Hora: <input type="text" name="data_hora" /><br/>
        <input type="submit" value="Salvar" />
        <input type="hidden" name="cpf_cli" value="<%=cpf_cli%>"/>
    </fieldset>
</form>