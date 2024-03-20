package br.com.gibran.modelos;

public class Contato {

	private static int codigoUnico = 0;
	private String nome;
	private int codigo;
	private String telefone;
	private Contato direito;
	private Contato esquerdo;

	public Contato(String nome, String telefone, Contato direito, Contato esquerdo) {
		codigoUnico++;
		this.codigo = codigoUnico;
		this.nome = nome;
		this.telefone = telefone;
		this.direito = direito;
		this.esquerdo = esquerdo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String  getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Contato getDireito() {
		return direito;
	}

	public void setDireito(Contato direito) {
		this.direito = direito;
	}

	public Contato getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(Contato esquerdo) {
		this.esquerdo = esquerdo;
	}

	public boolean ehFolha() {
		return (direito == null && esquerdo == null);
	}

	@Override
	public String toString() {
		return """
				Código: %d
				Nome: %s
				Telefone: %s
				""".formatted(this.getCodigo(), this.getNome(), this.getTelefone());
	}
}
