package controller;
import DAO.DAOEntidade;
import modelo.Classe_Judicial;
import modelo.Entidade;
import Banco.ConexaoSQLite;
import modelo.Entidade;
import repository.SeleniumRepositorio;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import repository.SeleniumRepositorio;

public class GeralController {
    private SeleniumRepositorio alerquina = new SeleniumRepositorio();
    private BancoController coringa = new BancoController();
    public String figaro() throws InterruptedException, AWTException {
       alerquina.login();
       String janelapadrao = alerquina.automatização();
       Entidade entidade = coringa.dadosEntidade();
       String classes = entidade.getId_classe_judicial();
       List<String> id_classes = new ArrayList<>(Arrays.asList(classes.split(",")));
        for(int i = 0; i < id_classes.size(); i++){

            String pesquisaClasse = (id_classes.get(i));
            Classe_Judicial classe = coringa.dadosjudicial(pesquisaClasse);
            String judicialclass=classe.getNome();
            alerquina.entradadados(judicialclass);
            alerquina.pesquisa(janelapadrao);
        }
        return null;
    }
}
