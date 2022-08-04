package modelo;

public class Entidade {

    private String nome;
    private String sigla;
    private String id_classe_judicial;
    private String id_assunto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getId_classe_judicial() {
        return id_classe_judicial;
    }

    public void setId_classe_judicial(String id_classe_judicial) {
        this.id_classe_judicial = id_classe_judicial;
    }

    public String getId_assunto() {
        return id_assunto;
    }

    public void setId_assunto(String id_assunto) {
        this.id_assunto = id_assunto;
    }
}
