package controller;

import Banco.ConexaoSQLite;
import modelo.Classe_Judicial;
import modelo.Entidade;
import repository.SeleniumRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BancoController {

    ControllerEntidade controllerEntidade;
    private SeleniumRepositorio repository = new SeleniumRepositorio();

    public Entidade dadosEntidade() {
        Entidade entidade = new Entidade();
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        conexaoSQLite.conectar();
        String sql = "SELECT * FROM Entidade where nome ="+"'"+"INSTITUTO NACIONAL DO SEGURO SOCIAL"+"'";
        PreparedStatement statement = conexaoSQLite.criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            ResultSet resultSet = statement.executeQuery();
                entidade.setNome(resultSet.getString("nome"));
                entidade.setSigla(resultSet.getString("sigla"));
                entidade.setId_classe_judicial(resultSet.getString("id_classe_judicial"));
                entidade.setId_assunto(resultSet.getString("id_assunto"));

            }
            catch (Exception e){

            }
        conexaoSQLite.desconectar();
        return entidade;
    }
    public Classe_Judicial dadosjudicial(String pesquisaClasse) {
        Classe_Judicial classe = new Classe_Judicial();
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        conexaoSQLite.conectar();
        String sql = "SELECT * FROM Classe_Judicial where id=" + pesquisaClasse;
        PreparedStatement statement = conexaoSQLite.criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            ResultSet resultSet = statement.executeQuery();
            classe.setNome(resultSet.getString("nome"));

        }
        catch (Exception e){

        }
        conexaoSQLite.desconectar();
        return classe;
    }

    public List<Entidade> entidadeList() {

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        conexaoSQLite.conectar();
        String sql = "SELECT * FROM Entidade";
        PreparedStatement statement = conexaoSQLite.criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        @SuppressWarnings("unchecked")
                List<Entidade> lista = new ArrayList<Entidade>();

        try {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Entidade entidade = new Entidade();
                entidade.setNome(resultSet.getString("nome"));
                entidade.setSigla(resultSet.getString("sigla"));
                entidade.setId_classe_judicial(resultSet.getString("id_classe_judicial"));
                entidade.setId_assunto(resultSet.getString("id_assunto"));

                lista.add(entidade);

            }
        } catch (Exception e) {

        }
        conexaoSQLite.desconectar();
        return lista;
    }
}
