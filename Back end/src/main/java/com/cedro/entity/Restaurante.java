package com.cedro.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * Classe responsavel pelo mapeamento do objeto Restaurante
 * @author bruno
 *
 */
@Entity
@Table(name = "TB_RESTAURANTE", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_NOM_RESTAURANTE", columnNames = { "NOM_RESTAURANTE" }) })
@SequenceGenerator(name = "SQ_RESTAURANTE", sequenceName = "SQ_RESTAURANTE", allocationSize = 1, initialValue = 1)
public class Restaurante {
	@Column(name = "COD_RESTAURANTE")
	@Id
	@GeneratedValue(generator = "SQ_RESTAURANTE", strategy = GenerationType.SEQUENCE)
	private Integer codigo;

	@Column(name = "NOM_RESTAURANTE", length = 100, nullable = false)
	private String nome;
	
	public Restaurante(){
		
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
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
}
