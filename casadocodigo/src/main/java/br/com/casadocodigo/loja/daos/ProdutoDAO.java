package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void save(Produto produto) {
        manager.persist(produto);
    }

    public List<Produto> findALl(){
        return manager.createQuery("select p from Produto p",Produto.class).getResultList();
    }

    public Produto findById(Integer id) {
        Produto result = manager.createQuery("select distinct(p) from Produto p " +
                                             "JOIN fetch p.precos WHERE p.id = :id", Produto.class)
                                             .setParameter("id", id)
                                             .getSingleResult();
        return result;
    }
}
