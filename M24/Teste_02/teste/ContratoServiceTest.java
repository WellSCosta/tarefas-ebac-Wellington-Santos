import dao.ContratoDao;
import dao.IContratoDao;
import dao.mock.ContratoDaoMock;
import org.junit.Assert;
import org.junit.Test;
import service.ContratoService;
import service.IContratoService;

public class ContratoServiceTest {

    /**
     * Teste do método Salvar
     */
    @Test
    public void salvarTest() {
        IContratoDao mockDao = new ContratoDaoMock();

        IContratoService service = new ContratoService(mockDao);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso em salvar", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();

        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();

        Assert.assertEquals("Sucesso em salvar", retorno);
    }

    /**
     * Teste do método Buscar
     */
    @Test
    public void buscarTest() {
        IContratoDao mockDao = new ContratoDaoMock();

        IContratoService service = new ContratoService(mockDao);
        String retorno = service.buscar();

        Assert.assertEquals("Sucesso na busca", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoBuscarTest() {
        IContratoDao dao = new ContratoDao();

        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();

        Assert.assertEquals("Sucesso na busca", retorno);
    }

    /**
     * Teste do método Atualizar
     */
    @Test
    public void atualizarTest() {
        IContratoDao mockDao = new ContratoDaoMock();

        IContratoService service = new ContratoService(mockDao);
        String retorno = service.atualizar();

        Assert.assertEquals("Sucesso ao atualizar", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoAtualizarTest() {
        IContratoDao dao = new ContratoDao();

        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();

        Assert.assertEquals("Sucesso ao atualizar", retorno);
    }

    /**
     * Teste do método Excluir
     */
    @Test
    public void excluirTest() {
        IContratoDao mockDao = new ContratoDaoMock();

        IContratoService service = new ContratoService(mockDao);
        String retorno = service.excluir();

        Assert.assertEquals("Sucesso ao excluir", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirTest() {
        IContratoDao dao = new ContratoDao();

        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();

        Assert.assertEquals("Sucesso ao excluir", retorno);
    }
}
