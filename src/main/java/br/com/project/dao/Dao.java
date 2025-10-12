package br.com.project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {
    private EntityManagerFactory emf;
    public EntityManager em;

    public Dao() {

    }
    public void IniciarConexao() {
        try {//try-catch para captura de erro ao realizar conexao com o banco
            emf = Persistence.createEntityManagerFactory("Ordem_De_Servico");
            em = emf.createEntityManager();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public void FecharConexao() {
        this.em.close();
        this.emf.close();
    }
}
