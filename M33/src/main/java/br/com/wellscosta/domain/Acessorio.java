/**
 * 
 */
package br.com.wellscosta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Wellington
 */
@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
	@SequenceGenerator(name = "acessorio_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;
	
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "CODIGO", length = 50, nullable = false, unique = true)
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "id_carro_fk", 
	foreignKey = @ForeignKey(name = "fk_acessorio_carro"),
	referencedColumnName = "id", nullable = false)
	private Carro carro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	

}
