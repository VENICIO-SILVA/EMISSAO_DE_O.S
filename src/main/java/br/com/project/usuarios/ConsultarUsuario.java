package br.com.project.usuarios;

import br.com.project.conexao.Dao;
import jakarta.persistence.TypedQuery;

import java.util.List;

import javax.swing.*;

//esta Classe no atual momento nao vai ser usada.
//todo decidir onde vai usar a classe
public class ConsultarUsuario {
    private String usuario;

    public ConsultarUsuario() {

    }

    public void GetINomeUsuTelaDeLogin(JTextField IdUser) {
        //recebe o id que foi usado para o login na tela de login
        this.usuario = IdUser.getText();
    }

    public Admins Consulta() {
        Dao conexao = new Dao();//conexao com banco
        conexao.IniciarConexao();
        try {
            String jpql = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario";//select na coluna usuario/nome do admin
            TypedQuery<Admins> query = conexao.em.createQuery(jpql, Admins.class);
            query.setParameter("usuario", this.usuario);//faz a consulta apenas do nome do usuario
            //no banco via os parametros recebidos nos primeiros metodos
            List<Admins> list = query.getResultList();
            if (list.isEmpty()) {
                return null;
            } else {
                return query.getSingleResult();
            }

        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}

