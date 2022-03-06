<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.domain.Profissional" %>
<%@ page import="br.ufscar.dc.dsw.dao.ProfissionalDAO" %>
<%@ page import="java.util.List" %>
<%
	String espec = request.getParameter("especFilter");
	String area = request.getParameter("areaFilter");
	ProfissionalDAO pDAO = new ProfissionalDAO();
	List<Profissional> p = pDAO.findAllProfissional();
%>
<table border="1">
        <tr>
            <td>Nome:</td>
            <td>Area:</td>
            <td>Especialidade:</td>
            <td>E-mail:</td>
        </tr>
        <% for(int i = 0; i < p.size(); i+=1) { %>
            <tr>      
                <td><%=p.get(i).getNome() %></td>
                <td><%=p.get(i).getArea_conhecimento()%></td>
                <td><%=p.get(i).getEspecialidade()%></td>
                <td><%=p.get(i).getEmail()%></td>
            </tr>
        <% } %>
</table> 