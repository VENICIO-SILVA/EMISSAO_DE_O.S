package br.com.project.usuarios;

import br.com.project.conexao.Dao;

import javax.swing.*;

public class CadastrarAdmin {
    public Admins Cadastrar(JTextField Usuario, JTextField Senha, JTextField telefone, JTextField gmail) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        Admins InsertUsuario = new Admins();
        try {
            if (Usuario.getText().isEmpty() && Senha.getText().isEmpty() && telefone.getText().isEmpty() && gmail.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                return InsertUsuario;//aqui eu retorno para nao precisar passar pelas verificações seguintes
            }
            boolean valido = true;
            //os "false" fazem a verificação continuar e caso encontrar "true" quer dizer q o campo esta preenchido e vai passar para a outra verificação
            if (Usuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "E obrigatorio fornecer um Nome de Usuário");
                valido = false;
            }

            if (Senha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "E obrigatorio fornecer numero para contato");
                valido = false;
            }

            if (telefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha o campo Endereço");
                valido = false;
            }

            if (gmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "E obrigatorio fornecer um E-mail");
                valido = false;
            }
            if (!valido) {
                return InsertUsuario;
            } else {
                InsertUsuario.setUsuario(Usuario.getText());
                InsertUsuario.setSenha(Senha.getText());
                InsertUsuario.setTelefone(telefone.getText());
                InsertUsuario.setGmail_login(gmail.getText());
                InsertUsuario.setPerfil("Admin");//esse comando dara automaticamente a indentidade de admin na coluna perfil do banco de dados
                conexao.em.getTransaction().begin();
                conexao.em.persist(InsertUsuario);
                conexao.em.getTransaction().commit();
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            conexao.FecharConexao();
        }
        return InsertUsuario;
    }
}
