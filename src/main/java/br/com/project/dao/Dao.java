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
        try {
            this.emf = Persistence.createEntityManagerFactory("Ordem_De_Servico");
            this.em = emf.createEntityManager();
        } catch (Exception e) {
            System.out.println("Erro de Conexão");
            e.printStackTrace(); // Mostra o erro real
        }
    }
    public void FecharConexao() {
        try {
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
