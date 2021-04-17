package main.java.br.com.caelum.livraria.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Autor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autors_seq_gen")
	@SequenceGenerator(name="autors_seq_gen", sequenceName = "autors_id_seq")
	private Integer id;
	private String nome;
	private String email;

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
