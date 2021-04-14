package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UsuarioDAO {



    public boolean existe(Usuario usuario) {

        EntityManager em = new JPAUtil().getEntityManager();
        TypedQuery<Usuario> query = em.createQuery("select u from Usuario u where u.email = :pEmail and u.senha = :pSenha", Usuario.class)
                .setParameter("pEmail", usuario.getEmail())
                .setParameter("pSenha", usuario.getSenha());

        try {
            Usuario resultado = query.getSingleResult();
        } catch(NoResultException ex) {
            return false;
        }
        em.close();

        return true;
    }
}
