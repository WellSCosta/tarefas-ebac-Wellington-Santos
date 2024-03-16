/**
 * 
 */
package br.com.wellscosta.domain;

/**
 * @author Wellington
 */
public class Cliente implements Persistente{
	
	private String nome;
	private Long cpf;
	private String cidade;
	private Long tel;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	
	
}
