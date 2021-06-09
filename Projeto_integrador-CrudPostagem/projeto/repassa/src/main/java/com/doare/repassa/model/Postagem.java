package com.doare.repassa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;


@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // chave primaria e auto incremente
	private long id;
	

	@Size(min = 1, max =500)
	private String titulo; //Link que será add no front-end
	
	
	@NotNull
	@Size(min = 1, max =500)
	private String texto;
	
	
	@Size(min = 1, max =500)
	private String img; //Link que será add no front-end
		
	
	@Temporal(TemporalType.TIMESTAMP) //data e hora é armazenada no momento da postagem
	private Date data = new java.sql.Date(System.currentTimeMillis());

	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne 
	@JsonIgnoreProperties("postagem")
	private User email;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public User getEmail() {
		return email;
	}

	public void setEmail(User email) {
		this.email = email;
	}

	
	
}
	