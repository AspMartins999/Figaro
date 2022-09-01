package controller;
import modelo.Assunto;
import modelo.Classe_Judicial;
import modelo.Entidade;
import repository.SeleniumRepositorio;

import java.awt.*;
import java.util.*;
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
        Set<String> exceões = new HashSet<String>(Arrays.asList(
                "AGÊNCIA NACIONAL DE ENERGIA ELÉTRICA", "AGÊNCIA NACIONAL DO PETROLEO, GAS NATURAL E BIOCOMBUSTIVEIS", "AGÊNCIA NACIONAL DE AVIAÇÃO CIVIL", "AGÊNCIA NACIONAL DE TELECOMUNICAÇÕES", "AGÊNCIA NACIONAL DE TRANSPORTES AQUAVIÁRIOS", "SUPERINTENDÊNCIA DE SEGUROS PRIVADOS", "AAGÊNCIA NACIONAL DO CINEMA", "AGÊNCIA NACIONAL DE ÁGUAS", "DEPARTAMENTO NACIONAL DE OBRAS CONTRA AS SECAS", "SUPERINTENDÊNCIA NACIONAL DE PREVIDÊNCIA COMPLEMENTAR", "COMISSÃO DE VALORES MOBILIÁRIOS", "AGÊNCIA NACIONAL DE SAUDE SUPLEMENTAR", "COMISSÃO NACIONAL DE ENERGIA NUCLEAR", "AGÊNCIA ESPACIAL BRASILEIRA", "AGÊNCIA NACIONAL DE TRANSPORTES TERRESTRES", "AGÊNCIA NACIONAL DE VIGILÂNCIA SANITÁRIA"));
        List<String> id_classes = new ArrayList<>(Arrays.asList(classes.split(",")));
        for(int i = 0; i < id_classes.size(); i++){

            String pesquisaClasse = (id_classes.get(i));

            Classe_Judicial classe = coringa.dadosjudicial(pesquisaClasse);
            String judicialclass=classe.getNome();
            alerquina.entradadados(judicialclass,nome,test);
            if(exceões.contains(entidade.getNome())){
                    alerquina.pesquisaExceçoes(janelapadrao);
            }else
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
            if(exceões.contains(entidade.getNome())){
                alerquina.pesquisaExceçoes(janelapadrao);
            }else
                alerquina.pesquisa(janelapadrao);
        }
        return null;
    }
}
