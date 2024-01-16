package domain;

import java.util.Objects;

public class Cliente {

    private String nome;
    private Long cpf;
    private Long tel;
    private String end;
    private Integer numero;
    private String cidade;
    private String estado;


    /*Metodo construtor :
    Usando ".valueOf" para formatar o tipo (criar um obj a partir de um valor primitivo)
    e ".trim" para remover os espaços em branco*/
    public Cliente(String nome, String cpf, String tel, String end, String num, String cidade, String estado) {
        this.nome = nome;
        this.cpf = Long.valueOf(cpf.trim());
        this.tel = Long.valueOf(tel.trim());
        this.end = end;
        this.numero = Integer.valueOf(num.trim());
        this.cidade = cidade;
        this.estado = estado;
    }

    //Get e Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*O método equals() nos permite verificar uma comparação entre os objetos.
    Tal comparação tem a finalidade de verificar se o valor/tipo dos atributos que estão sendo comparados são iguais.
    Isto é, é através do método equals() que você poderá determinar se os objetos são iguais.*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }
    /*Temos que elementos podem ser armazenados em estruturas onde a informação é referenciada por uma chave.
    Esta chave, que também podemos chamar de “número hash”, é calculada com base nas propriedades da informação.
    (A partir da quantidade de letras do nome, multiplicada por 8, geraria uma chave individual com o posicionamento de cada participante.
    A este processo damos o nome de (Ordenação precisa de comparação) em uma tabela hashing.)*/

    /*Enfim, sempre que precisarmos ordenar e comparar objetos Java em tempo de execução os métodos equals e hashcode deverão ser implementados.*/
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return  "\nNome: " + nome +
                "\nTelefone: " + tel +
                "\nCidade: " + cidade;
    }


}
