package br.org.trabalhomatheus.repository;

import br.org.trabalhomatheus.model.Funcionario;
import br.org.trabalhomatheus.model.Restaurante;

import javax.persistence.*;
import java.util.List;


public class FuncionarioRepository {

    private EntityManager em;

    public FuncionarioRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EscolaDB");
        em = factory.createEntityManager();
    }

    public void inserir(Funcionario funcionario){
        this.em.getTransaction().begin();
        this.em.merge(funcionario);
        this.em.getTransaction().commit();
    }

    public List<Funcionario> buscar(){
        TypedQuery<Funcionario> buscarTodosQuery = this.em.createQuery("select e from Funcionario e", Funcionario.class);
        return buscarTodosQuery.getResultList();
    }

    public Funcionario buscar(Integer id){
        return this.em.find(Funcionario.class, id);
    }

    public void atualizar(Funcionario funcionario){
        this.em.merge(funcionario);
    }

    public void remove(Funcionario funcionario){
        this.em.remove(funcionario);
    }
}
