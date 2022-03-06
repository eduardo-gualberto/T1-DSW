package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente extends Pessoa{
	@Column(nullable = false, unique = false, length = 1)
	private String sexo;
	
	@Column(nullable = false, unique = true, length = 15)
	private String telefone;
	
	@Column(nullable = false, unique = false, length = 10)
	private String data_nascimento;

	public Cliente() {}
	public Cliente(String nome, String cpf, String email, String senha, String sexo, String telefone, String data_nascimento) {
		super(nome, cpf, email, senha);
		this.sexo = sexo;
		this.telefone = telefone;
		this.data_nascimento = data_nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	
}