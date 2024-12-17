package br.org.trabalhomatheus.repository;

import br.org.trabalhomatheus.model.Voto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VotoRepository {

    private EntityManager em;

    public VotoRepository(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EscolaDB");
        em = factory.createEntityManager();
    }

    public List<Voto> buscar(){

    }
}
