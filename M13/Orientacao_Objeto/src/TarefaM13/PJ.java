package TarefaM13;

public class PJ extends Pessoa{
    private Long cnpj;

    public PJ(Long cnpj, String nome, String sexo) {
        this.cnpj = cnpj;
        this.setNome(nome);
        this.setSexo(sexo);
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "\nCNPJ: " + cnpj +
                "\nNome: " + this.getNome() +
                "\nSexo: " + this.getSexo();
    }
}
