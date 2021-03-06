package br.com.ongvd.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class ServicoVoluntario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false, length = 5000)
	private String descricao;
	@Column(nullable = false)
	private Timestamp dataInclusao;
	@Column
	private Timestamp dataAtualizacao;
	@Column
	private Timestamp dataDesabilitado;
	@Column
	private Boolean habilitado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ong_id")
	private Ong ong;

	public ServicoVoluntario() {
	}

	public ServicoVoluntario(String nome, @Size(min = 10, max = 5000) String descricao, Timestamp dataInclusao,
			Timestamp dataAtualizacao, Timestamp dataDesabilitado, Boolean habilitado, Ong ong) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
		this.dataDesabilitado = dataDesabilitado;
		this.habilitado = habilitado;
		this.ong = ong;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Timestamp dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Timestamp getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Timestamp dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Timestamp getDataDesabilitado() {
		return dataDesabilitado;
	}

	public void setDataDesabilitado(Timestamp dataDesabilitado) {
		this.dataDesabilitado = dataDesabilitado;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoVoluntario other = (ServicoVoluntario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServicoVoluntario [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataInclusao="
				+ dataInclusao + ", dataAtualizacao=" + dataAtualizacao + ", dataDesabilitado=" + dataDesabilitado
				+ ", habilitado=" + habilitado + ", ong=" + ong + "]";
	}

}
