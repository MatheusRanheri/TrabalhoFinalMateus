package br.org.trabalhomatheus.repository;

import br.org.trabalhomatheus.model.Funcionario;
import br.org.trabalhomatheus.model.Restaurante;

import javax.persistence.*;
import java.util.List;

public class RestauranteRepository {

    private EntityManager em;

    public RestauranteRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EscolaDB");
        em = factory.createEntityManager();
    }

    public void inserir(Restaurante restaurante) {
        this.em.getTransaction().begin();
        this.em.persist(restaurante);
        this.em.getTransaction().commit();
    }

    public List<Restaurante> buscar(){
        TypedQuery<Restaurante> buscarTodosQuery = this.em.createQuery("select e from Restaurante e", Restaurante.class);
        return buscarTodosQuery.getResultList();
    }


}
