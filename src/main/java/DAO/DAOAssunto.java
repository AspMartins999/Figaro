package DAO;

import Banco.ConexaoSQLite;
import modelo.Assunto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOAssunto extends ConexaoSQLite {

    public boolean salvarAssunto (Assunto assunto) {
        conectar();
        String sql = "INSERT INTO Assunto(" +
                "nome)" +
                "VALUES (?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, assunto.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        desconectar();
        return true;
    }

    public boolean excluirAssunto() {
        conectar();
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM Assunto";
        preparedStatement = this.criarPreparedStatement(sql);
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }catch (SQLException e) {

                    e.printStackTrace();
                }
            }
        }
        this.desconectar();
        return true;
    }
}