package br.com.project.conexao;

public class TESTECONEXAO {
    public static void main(String[] args) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        conexao.FecharConexao();
    }
}
