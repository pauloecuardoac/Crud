package com.br.business.dto;

import java.io.Serializable;

import com.br.business.entities.Consulta;

public class ConsultaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cnpj;
	private String email;
	private String empresa;
	
	public ConsultaDTO() {
		
	}

	public ConsultaDTO(Long id, String nome, String cnpj, String email, String empresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.empresa = empresa;
	}
	
	public ConsultaDTO(Consulta entity) {
		
		id = entity.getId();
		nome = entity.getNome();
		cnpj = entity.getCnpj();
		email = entity.getEmail();
		empresa = entity.getEmpresa();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}
