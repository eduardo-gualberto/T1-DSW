<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.ufscar.dc.dsw.controller.LogInController" %>
<%@ page import="br.ufscar.dc.dsw.dao.PessoaDAO" %>
<%
	String opcao = request.getParameter("opcao");
// 	String curriculo = request.getAttribute("curriculo");
	if(opcao.equals("cliente")) {
%>
	<form action="registerCliente.jsp" method="POST">
        <fieldset>
            <legend>Registrar Cliente</legend>
            Nome: <input type="text" name="nome" /><br/>
            E-mail: <input type="text" name="email" /><br/>
            Senha: <input type="password" name="senha" /><br/>
            CPF: <input type="text" name="cpf" /><br/>
            Telefone: <input type="text" name="telefone" /><br/>
            Data de Nascimento (DD/MM/AAAA): <input type="text" name="dataNasc" /><br/><br/>
            Sexo:<br/>
            Masculino <input type="checkbox" name="sexo" value="M"/><br/>
            Feminino <input type="checkbox" name="sexo" value="F"/><br/>
            <input type="submit" value="Salvar" />
        </fieldset>
    </form>
<% } else if(opcao.equals("profissional")){ %>
	<form action="registerProfissional.jsp" method="POST">
        <fieldset>
            <legend>Registrar Profissional</legend>
            Nome: <input type="text" name="nome" /><br/>
            E-mail: <input type="text" name="email" /><br/>
            Senha: <input type="password" name="senha" /><br/>
            CPF: <input type="text" name="cpf" /><br/><br/>
            
            Area de Conhecimento:<br/>
            Medicina <input type="checkbox" name="areaCon" value="Medicina"/><br/>
            Psicologia <input type="checkbox" name="areaCon" value="Psicologia"/><br/>
            Fisioterapia <input type="checkbox" name="areaCon" value="Fisioterapia"/><br/>
            Nutrição <input type="checkbox" name="areaCon" value="Nutrição"/><br/><br/>
            
            Especialidade:<br/>
            Cardiologia <input type="checkbox" name="especialidade" value="Cardiologia"/><br/>
            Dermatologia <input type="checkbox" name="especialidade" value="Dermatologia"/><br/>
            Psicologia Clinica <input type="checkbox" name="especialidade" value="Psico. Clinica"/><br/>
            Psicologia Pedagogica <input type="checkbox" name="especialidade" value="Psico. Pedagogica"/><br/>
            Fisioterapia Esportiva <input type="checkbox" name="especialidade" value="Fisio. Esportiva"/><br/>
            Fisioterapia Clinica <input type="checkbox" name="especialidade" value="Fisio. Clinica"/><br/>
			Nutrição Esportiva <input type="checkbox" name="especialidade" value="Nutri. Esportiva"/><br/>
            Nutrição Clinica <input type="checkbox" name="especialidade" value="Nutri. Clinica"/><br/><br/>          	
            <input type="submit" value="Register" />
        </fieldset>
    </form>
    <form action="registerUploadCV.jsp" method="POST" enctype="multipart/form-data">
    		Anexar Curriculo:<br/>
            Curriculo PDF: <input type="file" name="file" size="50" /><br/>         	
            <input type="submit" value="Enviar" />
    </form>
<% } %>