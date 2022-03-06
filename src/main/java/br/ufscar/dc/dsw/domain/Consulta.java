package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Consulta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Consulta {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = false, length = 20)
	private String data_hora;
	
	@Column(nullable = false, unique = false, length = 20)
	private String CPF_profissional;
	
	@Column(nullable = false, unique = false, length = 20)
	private String CPF_cliente;
	
	public Consulta() {}
	public Consulta(String data_hora, String cPF_profissional, String cPF_cliente) {
		super();
		this.data_hora = data_hora;
		CPF_profissional = cPF_profissional;
		CPF_cliente = cPF_cliente;
	}

	public Long getId() {
		return id;
	}

	public String getData_hora() {
		return data_hora;
	}

	public void setData_hora(String data_hora) {
		this.data_hora = data_hora;
	}

	public String getCPF_profissional() {
		return CPF_profissional;
	}

	public void setCPF_profissional(String cPF_profissional) {
		CPF_profissional = cPF_profissional;
	}

	public String getCPF_cliente() {
		return CPF_cliente;
	}

	public void setCPF_cliente(String cPF_cliente) {
		CPF_cliente = cPF_cliente;
	}
	
	
}
