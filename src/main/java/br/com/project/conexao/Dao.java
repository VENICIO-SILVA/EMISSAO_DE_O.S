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
    public void IniciarConexao(){
        try {
            emf = Persistence.createEntityManagerFactory("Ordem_De_Servico");
            em = emf.createEntityManager();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void FecharConexao() {
        this.em.close();
        this.emf.close();
    }
}
