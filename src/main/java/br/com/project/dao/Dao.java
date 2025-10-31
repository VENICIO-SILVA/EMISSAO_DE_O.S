package br.com.project.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    private EntityManagerFactory emf;
    public EntityManager em;

    private Connection conn;


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
    //este metodo foi criado pois na classe controller "GerarRelatorio e esperado um "Connection" e nao consegui usar o Dao "emf" e "em"
    public Connection getConnection() throws Exception {
        if (conn == null || conn.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/projetoos";
            String user = "root";
            String password = "coxinha220";
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }
}
