package br.com.ongvd.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.DateTimeFormat;

public class OngEdicaoDTO {
	
	private Long id;
	@NotBlank(message = "Por favor preencha este campo")
	private String razaoSocial;
	@NotBlank(message = "Por favor preencha este campo")
	private String nomeFantasia;
	@CNPJ(message = "Por favor preencha este campo com um CNPJ válido")
	private String cnpj;
	@NotBlank(message = "Por favor preencha este campo")
	private String areaDeAtuacao;
	private String website;
	@NotBlank(message = "Por favor preencha este campo")
	private String responsavel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fundacao;
	@NotBlank(message = "Por favor preencha este campo")
	private String contato;
	private String whatsapp;
	@Pattern(regexp = "^\\([1-9]{2}\\) ([0-9]{4}|[0-9]{5})\\-[0-9]{4}$", message = "Por favor preencha este campo corretamente")
	private String telefone;
	@Email(message = "Não é um endereço de e-mail válido")
	@NotBlank(message = "Por favor preencha este campo")
	private String email;
	@Size(min = 6, max = 20, message = "Tamanho da senha entre 6 a 20 caracteres")
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAreaDeAtuacao() {
		return areaDeAtuacao;
	}

	public void setAreaDeAtuacao(String areaDeAtuacao) {
		this.areaDeAtuacao = areaDeAtuacao;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Date getFundacao() {
		return fundacao;
	}

	public void setFundacao(Date fundacao) {
		this.fundacao = fundacao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
