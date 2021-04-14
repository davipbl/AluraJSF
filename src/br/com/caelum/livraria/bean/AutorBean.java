package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

import java.util.List;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	private Integer autorId;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public void carregarAutorPelaId() {
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
	}

	public Autor getAutor() {
		return autor;
	}

	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public void gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (this.autor.getId() == null) {
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		} else {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}
		this.autor = new Autor();


		//(método retornava String) return "livro?faces-redirect=true";
	}

	public void remover(Autor autor) {
		System.out.println("Removendo autor");
		new DAO<Autor>(Autor.class).remove(autor);
	}

	public void carregar(Autor autor) {
		System.out.println("Carregando autor: " + this.autor.getNome());
		this.autor = autor;
	}


}
