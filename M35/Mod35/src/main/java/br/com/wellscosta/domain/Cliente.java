/**
 * 
 */
package br.com.wellscosta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.wellscosta.dao.Persistente;

/**
 * @author WellSCosta
 */

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Persistente{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	@SequenceGenerator(name = "cliente_seq", sequenceName = "sq_cliente", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "cpf", nullable = false, unique = true)
	private Long cpf;
	
	@Column(name = "telefone", nullable = false)
	private Long tel;
	
	@Column(name = "numero", nullable = false)
	private Integer num;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "endereco", length = 100, nullable = false)
	private String end;
	
	@Column(name = "cidade", length = 100, nullable = false)
	private String cid;
	
	@Column(name = "estado", length = 50, nullable = false)
	private String est;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getEst() {
		return est;
	}

	public void setEst(String est) {
		this.est = est;
	}
	
	
	
}
