package br.org.trabalhomatheus.repository;

import br.org.trabalhomatheus.model.Funcionario;

import javax.persistence.*;
import java.util.List;


public class FuncionarioRepository {

    private EntityManager em; //Gerencia as entidades (Objetos que representam registros em tabelas de bancos de dados).

    public FuncionarioRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabFinalMateus"); //Cria uma EntityManagerFactory a partir de uma unidade de persistência configurada no arquivo persistence.xml, o nome TrabFinalMateus também vem dessa classe.
        this.em = factory.createEntityManager();
    }

    public void inserirFuncionario(Funcionario funcionario){
        this.em.getTransaction().begin();
        this.em.merge(funcionario);
        this.em.getTransaction().commit();
    }

    public void removerFuncionario(Funcionario funcionario){
        this.em.getTransaction().begin();
        this.em.remove(funcionario);
        this.em.getTransaction().commit();
    }

    public void atualizarFuncionario(Funcionario funcionario){
        this.em.getTransaction().begin();
        this.em.merge(funcionario);
        this.em.getTransaction().commit();
    }

    public Funcionario buscarFuncionario(String nome){
        TypedQuery<Funcionario> buscarTodosQuery = this.em.createQuery("select f from Funcionario f where UPPER(f.nome) like :nome ", Funcionario.class);
        buscarTodosQuery.setParameter("nome", "%" + nome.toUpperCase() + "%");

        try{
            return buscarTodosQuery.getSingleResult();
        }catch (NoResultException e) {
            return  null;
        }
    }

    public List<Funcionario> buscar(){
        TypedQuery<Funcionario> buscarTodosQuery = this.em.createQuery("select f from Funcionario f order by f.nome", Funcionario.class);
        return buscarTodosQuery.getResultList();
    }

    public Funcionario buscarFuncionario(Integer id){
        TypedQuery<Funcionario> buscarTodosQuery = this.em.createQuery("select f from Funcionario f where f.id like :id ", Funcionario.class);
        buscarTodosQuery.setParameter("id",  id)    ;

        try{
            return buscarTodosQuery.getSingleResult();
        }catch (NoResultException e) {
            return  null;
        }
    }


    public void atualizar(Funcionario funcionario){
        this.em.merge(funcionario);
    }

    public void remove(Funcionario funcionario){
        this.em.remove(funcionario);
    }




}
