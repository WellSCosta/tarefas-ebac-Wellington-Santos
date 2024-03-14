package service;

import dao.IContratoDao;

public class ContratoService implements IContratoService {

    IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        //throw new UnsupportedOperationException("Não pode sem banco");
        contratoDao.salvar();
        return "Sucesso em salvar";
    }

    @Override
    public String buscar() {
        contratoDao.buscar();
        return "Sucesso na busca";
    }

    @Override
    public String atualizar() {
        contratoDao.atualizar();
        return "Sucesso ao atualizar";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Sucesso ao excluir";
    }
}
