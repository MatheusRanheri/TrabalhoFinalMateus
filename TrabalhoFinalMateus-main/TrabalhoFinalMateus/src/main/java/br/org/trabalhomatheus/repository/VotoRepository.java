package br.org.trabalhomatheus.repository;

import br.org.trabalhomatheus.model.Funcionario;
import br.org.trabalhomatheus.model.TotalFuncionariosRestaurante;
import br.org.trabalhomatheus.model.Voto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Classe VotoRepository que funciona como repositorio
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
public class VotoRepository {


    /**
     *Realiza operacoes de persistencia
     */
    private EntityManager em;


    /**
     *Construtor da classe VotoRepository
     *createEntityManagerFactory = cria uma fabrica de EntityManager
     *"TrabFinalMateus" = nome da unidade de persistencia na classe persistence.xml
     */
    public VotoRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabFinalMateus");
        this.em = factory.createEntityManager();
    }


    /**
     * TypedQuery = fazer querys, nesse caso vai retornar objetos do tipo Voto
     * createQuery = cria uma query
     * @return retorna uma lista de objetos
     */
    public List<Voto> buscarVoto(){
        TypedQuery<Voto> buscarTodosQuery = this.em.createQuery("select v from Voto v", Voto.class);
        return buscarTodosQuery.getResultList();
    }


    /**
     * @param voto Voto
     * Pega o objeto de transacao associado ao entityManager
     * .begin() inicia uma transacao no banco de dados
     * .merge serve para atualizar ou salvar uma entidade no banco de dados
     * .commit() finaliza a transacao
     */
    public void inserirVoto(Voto voto){
        this.em.getTransaction().begin();
        this.em.merge(voto);
        this.em.getTransaction().commit();
    }


    /**
     * Cria um calendar com a data atual
     * Cria uma query que junta a tabela id funcionario e nome restaurante contando os votos de cada funcionario nos resturantes dependendo da data
     * TypedQuery = fazer querys, nesse caso vai retornar objetos do tipo TotalFuncionariosRestaurante
     * createQuery = cria uma query
     * setParameter = substitui o parametro :data da query pela data atual obtida pelo calendar
     * @return retorna uma lista de objetos
     */
    public List<TotalFuncionariosRestaurante> TotalFuncionariosRestaurante(){
        Calendar caledar = Calendar.getInstance();
        String query = "select new br.org.trabalhomatheus.model.TotalFuncionariosRestaurante(r.nome, COUNT(r.id)) " +
                " from Voto v " +
                " inner join v.restaurante r " +
                " where v.data = :data " +
                " group by r.nome order by r.nome";

        TypedQuery<TotalFuncionariosRestaurante> TotalFuncionariosRestaurante = this.em.createQuery(query, TotalFuncionariosRestaurante.class);
        TotalFuncionariosRestaurante.setParameter("data", caledar);
        return TotalFuncionariosRestaurante.getResultList();
    }


}
