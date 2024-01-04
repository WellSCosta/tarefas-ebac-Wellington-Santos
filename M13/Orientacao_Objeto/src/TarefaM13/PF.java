package TarefaM13;

public class PF extends Pessoa{
    private Long cpf;

    public PF(Long cpf, String nome, String sexo) {
        this.cpf = cpf;
        this.setNome(nome);
        this.setSexo(sexo);
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nCPF: " + cpf +
                "\nNome: " + this.getNome() +
                "\nSexo: " + this.getSexo();
    }
}
