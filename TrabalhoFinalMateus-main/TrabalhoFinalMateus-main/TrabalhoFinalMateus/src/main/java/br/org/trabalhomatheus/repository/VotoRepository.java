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

public class VotoRepository {

    private EntityManager em;

    public VotoRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabFinalMateus");
        this.em = factory.createEntityManager();
    }

    public List<Voto> buscarVoto(){
        TypedQuery<Voto> buscarTodosQuery = this.em.createQuery("select v from Voto v", Voto.class);
        return buscarTodosQuery.getResultList();
    }

    public void inserirVoto(Voto voto){
        this.em.getTransaction().begin();
        this.em.merge(voto);
        this.em.getTransaction().commit();
    }

    public void removerVoto(Voto voto){
        this.em.getTransaction().begin();
        this.em.remove(voto);
        this.em.getTransaction().commit();
    }

    public void atualizarRestaurante(Voto voto){
        this.em.getTransaction().begin();
        this.em.merge(voto);
        this.em.getTransaction().commit();
    }

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
