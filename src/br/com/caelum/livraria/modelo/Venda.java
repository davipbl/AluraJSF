package br.com.caelum.livraria.modelo;

import javax.persistence.*;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_seq_gen")
    @SequenceGenerator(name="sale_seq_gen", sequenceName = "sale_id_seq")
    private Integer id;

    @ManyToOne
    private Livro livro;
    private Integer quantidade;



    public Venda(Livro livro, Integer quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public Venda() {
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
