package br.com.desafioestoque.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_secao")

public class Secao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Atributo nome precisa ser inserido.")
	@Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
	private String nome;
	
	@NotBlank(message = "Atributo Tipo precisa ser inserido.")
	@Size(min = 5, max = 255, message = "Número mínimo de caracteres é 5 e número máximo de caracteres é 255.")
	private String tipoSecao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "Volume é obrigatório.")
	@Positive(message = "O Volume deve ser maior do que zero.")
	private BigDecimal volumeSecao;
	
	@OneToMany(mappedBy = "secao", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("secao")
	private List<Bebida> bebida;
	
	public BigDecimal getVolumeSecao() {
		return volumeSecao;
	}

	public void setVolumeSecao(BigDecimal volumeSecao) {
		this.volumeSecao = volumeSecao;
	}
	
	public String getTipoSecao() {
		return tipoSecao;
	}

	public void setTipoSecao(String tipoSecao) {
		this.tipoSecao = tipoSecao;
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

	public List<Bebida> getBebida() {
		return bebida;
	}

	public void setBebida(List<Bebida> bebida) {
		this.bebida = bebida;
	}

}
