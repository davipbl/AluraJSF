package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.tx.Transacional;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped //javax.faces.view.ViewScoped
public class AutorBean implements Serializable {

	private Autor autor = new Autor();

	@Inject
	private AutorDao dao;

	private Integer autorId;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public void carregarAutorPelaId() {
		this.autor = this.dao.buscaPorId(autorId);
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		return this.dao.listaTodos();
	}

	@Transacional
	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (this.autor.getId() == null) {
			this.dao.adiciona(this.autor);
		} else {
			this.dao.atualiza(this.autor);
		}
		this.autor = new Autor();

		return "livro?faces-redirect=true";
	}

	@Transacional
	public void remover(Autor autor) {
		System.out.println("Removendo autor");
		this.dao.remove(autor);
	}

	public void carregar(Autor autor) {
		System.out.println("Carregando autor: " + this.autor.getNome());
		this.autor = autor;
	}


}
