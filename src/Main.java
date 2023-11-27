import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        String paramsConexao = "jdbc:h2:mem:testdb";
        String usuario = "";
        String senha = "";
        Connection conexao = DriverManager.getConnection(paramsConexao, usuario, senha);

        String criacaoSql = "create table pessoa (id int primary key, nome varchar(150), qtdAcesso int, naturalidade varchar(75) )";
        Statement stmtC = conexao.createStatement();
        stmtC.executeUpdate(criacaoSql);
        stmtC.close();

        String insereSql = "insert into pessoa (id, nome, qtdAcesso, naturalidade) values (1, 'Luiz Eduardo', 22, 'Patriota'), (2, 'Rafael', 22, 'Patriota'), (3 ,'Amanda', 13, 'Petista')";
        Statement stm = conexao.createStatement();

        stm.executeUpdate(insereSql);
        stm.close();

        String consulta = "select * from pessoa";

        ResultSet resultado = stmt.executeQuery(consulta);

        while (resultado.next()) {
            String nome = resultado.getString("nome");
            Integer quantidade = resultado.getInt("qtdAcesso");
            String naturalidade = resultado.getString("naturalidade");

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setQuantidadeAcesso(quantidade);
            pessoa.setNaturalidade(naturalidade);

            System.out.printf("Nome: %s\n", nome);
            System.out.printf("Quantidade de acessos: %d\n", quantidade);
            System.out.printf("Naturalidade: %s\n", naturalidade);
        }

        System.out.println("\nTchau, até a próxima\n\n\t\t:-)");
    }

}