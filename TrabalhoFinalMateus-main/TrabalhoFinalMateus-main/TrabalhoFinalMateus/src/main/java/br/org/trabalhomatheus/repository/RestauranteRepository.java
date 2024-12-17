package br.org.trabalhomatheus.repository;

import br.org.trabalhomatheus.model.Funcionario;
import br.org.trabalhomatheus.model.Restaurante;
import br.org.trabalhomatheus.model.TotalFuncionariosRestaurante;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe RestauranteRepository que funciona como repositorio
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
public class RestauranteRepository {


    /**
     *Realiza operacoes de persistencia
     */
    private EntityManager em;


    /**
     *Construtor da classe RestauranteRepository
     *createEntityManagerFactory = cria uma fabrica de EntityManager
     *"TrabFinalMateus" = nome da unidade de persistencia na classe persistence.xml
     */
    public RestauranteRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabFinalMateus");
        this.em = factory.createEntityManager();
    }



    /**
     * @param restaurante Restaurante
     * Pega o objeto de transacao associado ao entityManager
     * .begin() inicia uma transacao no banco de dados
     * .merge serve para atualizar ou salvar uma entidade no banco de dados
     * .commit() finaliza a transacao
     */
    public void inserirRestaurante(Restaurante restaurante){
        this.em.getTransaction().begin();
        this.em.merge(restaurante);
        this.em.getTransaction().commit();
    }


    /**
     * @param restaurante Restaurante
     * Pega o objeto de transacao associado ao entityManager
     * .begin() inicia uma transacao no banco de dados
     * .remove serve para remover a entidade passada como parametro
     * .commit() finaliza a transacao
     */
    public void removerRestaurante(Restaurante restaurante){
        this.em.getTransaction().begin();
        this.em.remove(restaurante);
        this.em.getTransaction().commit();
    }





    /**
     * @param nome String
     * TypedQuery = fazer querys, nesse caso vai retornar objetos do tipo Restaurante
     * createQuery = cria uma query
     * setParameter = substitui o parametro :nome da query pela String formatada
     * try catch = retorna nulo ao inves de uma excecao se nenhum objeto for encontrado
     * @return retorna o objeto funcionario referente a busca
     */
    public Restaurante buscarPorNome(String nome) {
        TypedQuery<Restaurante> buscar = this.em.createQuery("select r from Restaurante r where r.nome like :nome", Restaurante.class);
        buscar.setParameter("nome", nome);

        try{
            return buscar.getSingleResult();
        }catch (NoResultException e) {
            return  null;
        }
    }


    /**
     * TypedQuery = fazer querys, nesse caso vai retornar objetos do tipo Restaurante
     * createQuery = cria uma query
     * @return retorna uma lista de objetos
     */
    public List<Restaurante> buscar() {
        TypedQuery<Restaurante> buscarTodosQuery = this.em.createQuery("select r from Restaurante r order by r.id", Restaurante.class);
        return buscarTodosQuery.getResultList();
    }





}
