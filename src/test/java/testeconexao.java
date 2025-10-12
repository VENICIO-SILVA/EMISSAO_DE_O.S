import br.com.project.dao.Dao;
import org.junit.jupiter.api.Test;

class testeconexao {//classe de teste

    @Test
    void TesteDeConexao() {
        Dao conexao = new Dao();
        conexao.IniciarConexao();
        conexao.FecharConexao();
    }
}
