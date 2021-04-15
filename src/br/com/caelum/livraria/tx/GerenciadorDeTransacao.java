package br.com.caelum.livraria.tx;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {

    @Inject
    EntityManager manager;

    @AroundInvoke
    public Object executaTX(InvocationContext context) throws Exception {
        //abre transacao
        System.out.println("abrindo tx");
        manager.getTransaction().begin();

        //chamar os daos que precisam de uma TX
        Object resultado = context.proceed();

        System.out.println("fechando tx");
        //commita a transacao
        manager.getTransaction().commit();

        return resultado;
    }
}
