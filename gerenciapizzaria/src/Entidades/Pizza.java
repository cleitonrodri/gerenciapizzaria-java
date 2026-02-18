package Entidades;

public class Pizza {
	// atributos principais da pizza
	private int codigo;
	private String saborPizza;
	private String ingredientes;
	private double preco;
	private String tamanho;

	// construtor, traz os atributos ao criar um novo objeto
	public Pizza(int codigo, String saborPizza, String ingredientes, double preco, String tamanho) {
		this.codigo = codigo; // recebe o codigo informado
		this.saborPizza = saborPizza; // recebe o sabor informado
		this.ingredientes = ingredientes; // recebe o ingrediente informado
		this.preco = preco; // recebe o preço informado
		this.tamanho = tamanho; // rebce o tamanho informado
	}

	// metodos getters - retornam o valor atual do atributo
	// metodos setters - atualizam o valor daquele atributo
	public int getCodigo() {
		return codigo; // retorna o codigo da pizza
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo; // atualiza pra o novo codigo
	}

	public String getSaborPizza() {
		return saborPizza; // retorna o sabor da pizza
	}

	public void setSaborPizza(String saborPizza) {
		this.saborPizza = saborPizza; // atualiza pra o novo codigo
	}

	public String getIngredientes() {
		return ingredientes; // retorna os ingredientes da pizza
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes; // atualiza pra os novos ingredientes
	}

	public double getPreco() {
		return preco; // retorna o preco da pizza
	}

	public void setPreco(double preco) {
		this.preco = preco; // atualiza pra o novo preço
	}

	public String getTamanho() {
		return tamanho; // retorna o tamanho da pizza
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho; // atualiza pra o novo tamanho
	}
	
	// metodo toString - formata como vai sair a pizza caso for impressa
	@Override
	public String toString() {
		return " | Código: " + codigo + " | Sabor: " + saborPizza + " | Ingredientes: " + ingredientes + " | Preço: R$ "
				+ preco + " | Tamanho: " + tamanho;
	}
}