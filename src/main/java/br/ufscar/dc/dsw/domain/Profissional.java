package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Profissional")
public class Profissional extends Pessoa {
	
	@Column(nullable = false, unique = false, length = 20)
	private String area_conhecimento;
	
	public String getArea_conhecimento() {
		return area_conhecimento;
	}
	public void setArea_conhecimento(String area_conhecimento) {
		this.area_conhecimento = area_conhecimento;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	@Column(nullable = false, unique = false, length = 20)
	private String especialidade;
	
	//DESCOBRIR COMO FAZER COM O FORMATO PDF PARA STORAGE E ANOTAÇões
	@Column(nullable = false, unique = false, length = 1)
	private String curriculo;
	public Profissional() {}
	public Profissional(String nome, String cpf, String email, String senha, String area_conhecimento,
			String especialidade, String curriculo) {
		super(nome, cpf, email, senha);
		this.area_conhecimento = area_conhecimento;
		this.especialidade = especialidade;
		this.curriculo = curriculo;
	}

}
