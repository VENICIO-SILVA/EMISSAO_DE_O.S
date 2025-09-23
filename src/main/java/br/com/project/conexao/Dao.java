package br.com.project.conexao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ordem_De_Servico");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }
}
