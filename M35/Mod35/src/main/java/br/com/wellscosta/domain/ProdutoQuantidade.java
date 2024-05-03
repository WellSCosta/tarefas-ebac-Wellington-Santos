/**
 *
 */
package br.com.wellscosta.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
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

import br.com.wellscosta.dao.Persistente;

/**
 * @author WellSCosta
 */

@Entity
@Table(name = "tb_produto_quantidade")
public class ProdutoQuantidade implements Persistente{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_qtd_seq")
	@SequenceGenerator(name="prod_qtd_seq", sequenceName="sq_prod_qtd", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "valorTotal", nullable = false)
	private BigDecimal valorTotal;
	
	//ManyToOne por conta de muitas qtde de diferentes vendas pode ser do mesmo produto
	//Cascade para as operações de persistencia sejam sicronizadas entre essas entidades
	@ManyToOne(cascade = CascadeType.ALL)
	private Produto produto;
	
	//Mapeado na venda
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venda_fk", 
		foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"), 
		referencedColumnName = "id", nullable = false
	)
	private Venda venda;
	
	//Construtor para zerar os contadores
	public ProdutoQuantidade() {
		this.quantidade = 0;
		this.valorTotal = BigDecimal.ZERO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void adicionar(Integer quantidade) {
		this.quantidade += quantidade;
		
		BigDecimal valor = this.produto.getValor();
		BigDecimal novoValor = valor.multiply(BigDecimal.valueOf(quantidade));
		
		//Soma o valor total com o novo valor e atualiza o atributo
		this.valorTotal = this.valorTotal.add(novoValor);
	}
	
	public void remover(Integer quantidade) {
		this.quantidade -= quantidade;
		
		BigDecimal valor = this.produto.getValor();
		BigDecimal novoValor = valor.multiply(BigDecimal.valueOf(quantidade));
		
		this.valorTotal = this.valorTotal.subtract(novoValor);
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	

}
