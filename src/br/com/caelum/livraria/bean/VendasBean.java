package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Venda;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named
@ViewScoped
public class VendasBean implements Serializable {


    @Inject
    EntityManager manager;

    public BarChartModel getVendasModel() {

        BarChartModel model = new BarChartModel();
        model.setAnimate(true);

        ChartSeries vendaSerie = new ChartSeries();

        vendaSerie.setLabel("Vendas 2020");

        List<Venda> vendas = getVendas();

        for (Venda venda : vendas) {
            vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
        }

        model.addSeries(vendaSerie);

        return model;
    }

    public List<Venda> getVendas() {

        List<Venda> vendas = this.manager.createQuery("select v from Venda v", Venda.class).getResultList();


        return vendas;
    }
}
