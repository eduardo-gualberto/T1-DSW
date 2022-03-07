<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.domain.Consulta" %>
<%@ page import="br.ufscar.dc.dsw.dao.ConsultaDAO" %>
<%@ page import="br.ufscar.dc.dsw.dao.PessoaDAO" %>
<%@ page import="br.ufscar.dc.dsw.domain.Pessoa" %>

<%@ page import="java.util.List" %>

<%
	Object email = session.getAttribute("email");
	if(email == null){
%>
	<jsp:forward page="home.jsp">
    		<jsp:param name="email" value="<%=email %>" />
    		<jsp:param name="admin" value="T" />
    		<jsp:param name="type" value="A" />
	</jsp:forward>
<% }
String emailParsed = (String)email;
PessoaDAO pDAO = new PessoaDAO();
List<Pessoa> p = pDAO.findByEmail(emailParsed);
ConsultaDAO cDAO = new ConsultaDAO();
List<Consulta> c = cDAO.findByCPF(p.remove(0).getCpf());
%>
<table border="1">
        <tr>
            <td>CPF Profissional:</td>
            <td>CPF Cliente:</td>
            <td>Data e Hora:</td>
        </tr>
        <% for(int i = 0; i < c.size(); i+=1) { %>
            <tr>      
                <td><%=c.get(i).getCPF_profissional() %></td>
                <td><%=c.get(i).getCPF_cliente()%></td>
                <td><%=c.get(i).getData_hora()%></td>
            </tr>
        <% } %>
</table> 