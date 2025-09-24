import br.com.project.conexao.Dao;

public class testeconexao {//classe de teste
    public static void main(String[] args) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
    }
}
