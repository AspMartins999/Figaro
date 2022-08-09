package DAO;

import Banco.ConexaoSQLite;
import modelo.Classe_Judicial;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOClasseJudicial extends ConexaoSQLite {
    public boolean salvarClasseJudicial (Classe_Judicial classe) {
        conectar();
        String sql = "INSERT INTO Classe_Judicial("
                +"nome)"
                +"VALUES (?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, classe.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        desconectar();
        return true;
    }

    public boolean excluirClasseJudicial() {
        conectar();
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM Classe_Judicial";
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
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        this.desconectar();
        return true;
    }
}