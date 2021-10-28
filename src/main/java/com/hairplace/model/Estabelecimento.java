package com.hairplace.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "estabelecimentos")
public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "nome", unique = true, nullable = false)
	private String nome;
	
	@Column(name = "descricao", unique = true, nullable = false)
	private String descricao;
	
	@Column(name = "avaliacao", unique = true, nullable = false)
	private Double avaliacao;
	
	private List<Servico> servicos;
	
	public long getId() {
		return id;
	}
	
	public List<Servico> getServicos() {
		return servicos;
	}

}
