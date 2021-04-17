package main.java.br.com.caelum.livraria.dao;


import main.java.br.com.caelum.livraria.modelo.Livro;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class LivroDao implements Serializable {

    @Inject
    EntityManager manager;

    private DAO<Livro> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Livro>(this.manager, Livro.class);
    }

    public void adiciona(Livro livro) {
        dao.adiciona(livro);
    }

    public void remove(Livro livro) {
        dao.remove(livro);
    }

    public void atualiza(Livro livro) {
        dao.atualiza(livro);
    }

    public List<Livro> listaTodos() {
        return dao.listaTodos();
    }

    public Livro buscaPorId(Integer id) {
        return dao.buscaPorId(id);
    }
}
