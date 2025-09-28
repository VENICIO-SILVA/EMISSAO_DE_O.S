package br.com.project.usuarios;

import br.com.project.conexao.Dao;

import javax.swing.*;

public class CadastrarAdmin {
    public Usuarios Cadastrar(JTextField Usuario, JTextField Senha, JTextField telefone, JTextField gmail) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        Usuarios InsertUsuario = new Usuarios();
        try {
            //todo organizar logica dos campos vazios
            if (gmail.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Preencha o campo gmail");
                //como o email é unico no banco de dados se ele vier vazio do campo de inserção ja faço uma verifação para
                //mostrar um erro com letras estranhas na tela ou erro durante a execução
                if (Usuario.getText().isEmpty() && Senha.getText().isEmpty() && telefone.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha os campos");
                    return InsertUsuario;
                }
            } else {
                InsertUsuario.setUsuario(Usuario.getText());
                InsertUsuario.setSenha(Senha.getText());
                InsertUsuario.setTelefone(telefone.getText());
                InsertUsuario.setGmail_login(gmail.getText());
                conexao.em.getTransaction().begin();
                conexao.em.persist(InsertUsuario);
                conexao.em.getTransaction().commit();
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seu Gmail nao pode ser igual ao de Alguem ja Cadastrado");
        } finally {
            conexao.FecharConexao();
        }
        return InsertUsuario;
    }
}
