package Entidades;

// classe filha - ta herdando tudo ca classe mãe (Pizza)
public class PizzaDoce extends Pizza {

	// atributos exclusivos da classe filha (Pizza doce)
	private String coberturaEspecial;
	private String calda;

	// construtor - recebe todos os atributos da pizza normal + os da doce
	public PizzaDoce(int codigo, String saborPizza, String ingredientes, double preco, String tamanho, String coberturaEspecial, String calda) {
		// super - chama o construtor da classe mão (Pizza)
		super(codigo, saborPizza, ingredientes, preco, tamanho);
		// atributos proprios da pizza doce
		this.coberturaEspecial = coberturaEspecial;
		this.calda = calda;
	}

	// metodos getters - retornam o valor atual do atributo
	// metodos setters - atualizam o valor daquele atributo
	public String getCoberturaEspecial() {
		return coberturaEspecial; // retorna a coberturaEspecial da pizza ddoce
	}

	public void setCoberturaEspecial(String coberturaEspecial) {
		this.coberturaEspecial = coberturaEspecial; // atualiza a coberturaEspecial da pizza doce
	}

	public String getCalda() {
		return calda; // retorna a calda da pizza doce
	}

	public void setCalda(String calda) {
		this.calda = calda; //atualiza a calda da pizza doce
	}

	// metod toString - formata como vai sair a pizza doce caso for impressa
	// super.toString - puxa os atributos da classe mãe junta+ os atributos exclusivos da classe fila
	@Override
	public String toString() {
		return super.toString() + " | Cobertura Especial: " + coberturaEspecial + " | Calda: " + calda;
	}
}