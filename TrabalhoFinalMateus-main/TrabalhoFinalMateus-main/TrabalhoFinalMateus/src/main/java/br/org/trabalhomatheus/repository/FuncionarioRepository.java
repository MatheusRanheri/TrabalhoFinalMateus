package br.org.trabalhomatheus.repository;

import br.org.trabalhomatheus.model.Funcionario;

import javax.persistence.*;
import java.util.List;

/**
 * Classe FuncionarioRepository que funciona como repositorio
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
public class FuncionarioRepository {


    /**
     *Realiza operacoes de persistencia
     */
    private EntityManager em;


    /**
     *Construtor da classe FuncionarioRepository
     *createEntityManagerFactory = cria uma fabrica de EntityManager
     *"TrabFinalMateus" = nome da unidade de persistencia na classe persistence.xml
     */
    public FuncionarioRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabFinalMateus");
        this.em = factory.createEntityManager();
    }


    /**
     * @param funcionario Funcionario
     * Pega o objeto de transacao associado ao entityManager
     * .begin() inicia uma transacao no banco de dados
     * .merge serve para atualizar ou salvar uma entidade no banco de dados
     * .commit() finaliza a transacao
     */
    public void inserirFuncionario(Funcionario funcionario){
        this.em.getTransaction().begin();
        this.em.merge(funcionario);
        this.em.getTransaction().commit();
    }


    /**
     * @param funcionario Funcionario
     * Pega o objeto de transacao associado ao entityManager
     * .begin() inicia uma transacao no banco de dados
     * .remove serve para remover a entidade passada como parametro
     * .commit() finaliza a transacao
     */
    public void removerFuncionario(Funcionario funcionario){
        this.em.getTransaction().begin();
        this.em.remove(funcionario);
        this.em.getTransaction().commit();
    }



    /**
     * @param nome String
     * TypedQuery = fazer querys, nesse caso vai retornar objetos do tipo Funcionario
     * createQuery = cria uma query
     * setParameter = substitui o parametro :nome da query pela String formatada
     * try catch = retorna nulo ao inves de uma excecao se nenhum objeto for encontrado
     * @return retorna o objeto funcionario referente a busca
     */
    public Funcionario buscarFuncionario(String nome){
        TypedQuery<Funcionario> buscarTodosQuery = this.em.createQuery("select f from Funcionario f where UPPER(f.nome) like :nome ", Funcionario.class);
        buscarTodosQuery.setParameter("nome", "%" + nome.toUpperCase() + "%");

        try{
            return buscarTodosQuery.getSingleResult();
        }catch (NoResultException e) {
            return  null;
        }
    }


    /**
     * TypedQuery = fazer querys, nesse caso vai retornar objetos do tipo Funcionario
     * createQuery = cria uma query
     * @return retorna uma lista de objetos
     */
    public List<Funcionario> buscar(){
        TypedQuery<Funcionario> buscarTodosQuery = this.em.createQuery("select f from Funcionario f order by f.nome", Funcionario.class);
        return buscarTodosQuery.getResultList();
    }


    /**
     * @param id Integer
     * TypedQuery = fazer querys, nesse caso vai retornar objetos do tipo Funcionario
     * createQuery = cria uma query
     * setParameter = substitui o parametro :id da query pelo Integer formatado
     * try catch = retorna nulo ao inves de uma excecao se nenhum objeto for encontrado
     * @return retorna o objeto funcionario referente a busca
     */
    public Funcionario buscarFuncionario(Integer id){
        TypedQuery<Funcionario> buscarTodosQuery = this.em.createQuery("select f from Funcionario f where f.id like :id ", Funcionario.class);
        buscarTodosQuery.setParameter("id",  id)    ;

        try{
            return buscarTodosQuery.getSingleResult();
        }catch (NoResultException e) {
            return  null;
        }
    }




}
