package dao;

public class ContratoDao implements IContratoDao {
    @Override
    public String salvar() {
        throw new UnsupportedOperationException("Não pode salvar sem banco");
    }

    @Override
    public String buscar() {
        throw new UnsupportedOperationException("Não pode buscar sem banco");
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("Não pode atualizar sem banco");
    }

    @Override
    public String excluir() {
        throw new UnsupportedOperationException("Não pode excluir sem banco");
    }
}
