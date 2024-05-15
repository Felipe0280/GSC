package modelo;
public class Conta {

	private String nome;
	private int numeroConta;
	private int numeroTelefone;
	private float valorSaldo;
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public float getValorSaldo() {
		return valorSaldo;
	}

	public void setValorSaldo(float valorSaldo) {
		this.valorSaldo = valorSaldo;
	}

}
