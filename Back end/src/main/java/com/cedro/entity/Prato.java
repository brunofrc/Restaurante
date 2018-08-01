package com.cedro.entity;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




/**
 * Classe responsavel pelo mapeamento do objeto Prato
 * 
 * @author bruno
 *
 */
@Entity
@Table(name = "TB_PRATO", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_NOM_PRATO", columnNames = { "NOM_PRATO" }) })
@SequenceGenerator(name = "SQ_PRATO", sequenceName = "SQ_PRATO", allocationSize = 1, initialValue = 1)

public class Prato {

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	@Column(name = "COD_PRATO")
	@Id
	@GeneratedValue(generator = "SQ_PRATO", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "NOM_PRATO", length = 100, nullable = false)
	private String nome;

	@Column(name = "PRECO_PRATO", length = 100, nullable = false)
	private String preco;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurante.class)
	@JoinColumn(name = "COD_RESTAURANTE",nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_RESTAURANTE"))
	private Restaurante restaurante;

	/**
	 * Metodo responsavel por recuperar a propriedade nome
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo responsavel por alterar a propriedade nome
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Metodo responsavel por recuperar a propriedade preco
	 * 
	 * @return preco
	 */
	public String getPreco() {
		return preco;
	}
	/**
	 * Metodo responsavel por alterar a propriedade preco
	 * 
	 * @param preco
	 */
	public void setPreco(String preco) {
		this.preco = preco;
	}
	/**
	 * Metodo responsavel por recuperar a propriedade restaurante
	 * 
	 * @return restaurante
	 */
	public Restaurante getRestaurante() {
		return restaurante;
	}
	/**
	 * Metodo responsavel por alterar a propriedade restaurante
	 * 
	 * @param restaurante
	 */
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
}