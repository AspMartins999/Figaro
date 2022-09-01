package controller;
import modelo.Assunto;
import modelo.Classe_Judicial;
import modelo.Entidade;
import repository.SeleniumRepositorio;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeralController {
    private SeleniumRepositorio alerquina = new SeleniumRepositorio();
    private BancoController coringa = new BancoController();
    public String figaro() throws InterruptedException, AWTException {
       alerquina.login();
       String janelapadrao = alerquina.automatização();
       Entidade entidade = coringa.dadosEntidade();
       String classes = entidade.getId_classe_judicial();
       String nome= entidade.getNome();
       int test= 0;
       List<String> id_classes = new ArrayList<>(Arrays.asList(classes.split(",")));
        for(int i = 0; i < id_classes.size(); i++){

            String pesquisaClasse = (id_classes.get(i));

            Classe_Judicial classe = coringa.dadosjudicial(pesquisaClasse);
            String judicialclass=classe.getNome();
            alerquina.entradadados(judicialclass,nome,test);
            alerquina.pesquisa(janelapadrao);
        }
        String assuntos = entidade.getId_assunto();
        List<String> id_assuntos = new ArrayList<>(Arrays.asList(assuntos.split(",")));
        for(int i = 0; i < id_assuntos.size(); i++){
            test= 24;
            String pesquisaassunto = (id_assuntos.get(i));
            Assunto assunto = coringa.dadosassunto(pesquisaassunto);
            String Subject=assunto.getNome();
            alerquina.entradadados(Subject, nome, test);
            alerquina.pesquisa(janelapadrao);
        }
        return null;
    }
}
