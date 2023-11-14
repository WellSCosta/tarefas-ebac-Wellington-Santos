package br.com.well;

public class ClasseMain {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Wellington Santos");
		cliente.setEndereco("Endereco Well");
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("Endereço: " + cliente.getEndereco());
	}

}
