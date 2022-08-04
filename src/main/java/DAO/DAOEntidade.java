package DAO;

import Banco.ConexaoSQLite;
import modelo.Entidade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOEntidade extends ConexaoSQLite {

    public void salvarEntidadeDAO(Entidade entidade) {
        conectar();
        String sql = "INSERT INTO Entidade(" +
                "nome, " +
                "sigla, " +
                "id_classe_judicial, " +
                "id_assunto) " +
                "VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, entidade.getNome());
            preparedStatement.setString(2, entidade.getSigla());
            preparedStatement.setString(3, entidade.getId_classe_judicial());
            preparedStatement.setString(4, entidade.getId_assunto());
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        desconectar();
    }

    public void excluirEntidade()  {
        conectar();
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM entidade";


    }
}
