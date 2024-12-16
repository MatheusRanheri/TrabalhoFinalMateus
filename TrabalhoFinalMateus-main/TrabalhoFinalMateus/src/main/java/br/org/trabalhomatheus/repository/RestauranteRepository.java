package br.org.trabalhomatheus.repository;

import br.org.trabalhomatheus.model.Funcionario;
import br.org.trabalhomatheus.model.Restaurante;
import br.org.trabalhomatheus.model.TotalFuncionariosRestaurante;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class RestauranteRepository {

    private EntityManager em;

    public RestauranteRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabFinalMateus");
        this.em = factory.createEntityManager();
    }


    public void inserirRestaurante(Restaurante restaurante){
        this.em.getTransaction().begin();
        this.em.merge(restaurante);
        this.em.getTransaction().commit();
    }


    public void removerRestaurante(Restaurante restaurante){
        this.em.getTransaction().begin();
        this.em.remove(restaurante);
        this.em.getTransaction().commit();
    }

    public void atualizarRestaurante(Restaurante restaurante){
        this.em.getTransaction().begin();
        this.em.merge(restaurante);
        this.em.getTransaction().commit();
    }

    public Restaurante buscarPorNome(String nome) {
        TypedQuery<Restaurante> buscar = this.em.createQuery("select r from Restaurante r where r.nome like :nome", Restaurante.class);
        buscar.setParameter("nome", nome);

        try{
            return buscar.getSingleResult();
        }catch (NoResultException e) {
            return  null;
        }
    }

    public List<Restaurante> buscar() {
        TypedQuery<Restaurante> buscarTodosQuery = this.em.createQuery("select r from Restaurante r order by r.id", Restaurante.class);
        return buscarTodosQuery.getResultList();
    }


    public Restaurante buscarR(String id){
        return this.em.find(Restaurante.class, id);
    }

    public List<Restaurante> buscarRestaurante(){
        TypedQuery<Restaurante> buscarTodosQuery = this.em.createQuery("select r from Restaurante r order by r.nome", Restaurante.class);
        return buscarTodosQuery.getResultList();
    }

    public List<Restaurante> buscarRestaurantes(String nome){
        TypedQuery<Restaurante> buscarTodosQuery = this.em.createQuery("select r from Restaurante r where UPPER(r.nome) like : nome order by r.nome", Restaurante.class);
        buscarTodosQuery.setParameter("nome", nome.toUpperCase() + "%");

        return buscarTodosQuery.getResultList();
    }

}
