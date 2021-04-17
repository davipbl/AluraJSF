package main.java.br.com.caelum.livraria.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
	@SequenceGenerator(name="users_seq_gen", sequenceName = "users_id_seq")
	private Integer id;
	private String email;
	private String senha;

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
