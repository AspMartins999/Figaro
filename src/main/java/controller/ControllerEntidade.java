package controller;

import DAO.DAOEntidade;
import modelo.Entidade;

public class ControllerEntidade {
    DAOEntidade daoEntidade = new DAOEntidade();

    public boolean salvarEntidadeController(Entidade entidade){

        return this.daoEntidade.salvarEntidadeDAO(entidade);

    }

    public boolean excluirEntidadeController() {
        return this.daoEntidade.excluirEntidade();
    }
}
