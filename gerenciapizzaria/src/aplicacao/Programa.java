package aplicacao;

import java.util.ArrayList; // armazenar as listas
import java.util.Collections; // puxando pra poder ordenar a lista com o .sort()
import java.util.Comparator; // usado pra definir a regra de comparação
import java.util.Scanner; // ler dados digitados por alguem

import Entidades.Pizza; // classe mãe - usada pro arrayList de Pizzas Normais
import Entidades.PizzaDoce; // classe filha - usada para o arrayList de Pizzas Doces.

//classe principal do sistema
public class Programa {
	private static Scanner sc = new Scanner(System.in); // declarado fora da main assim podendo ser usado na classe toda

	private static ArrayList<Pizza> cardapio = new ArrayList<>(); // lista de pizzas normais
	private static ArrayList<PizzaDoce> cardapioDoce = new ArrayList<>(); // lista de pizzas doces

	// Declarando na Classe Programa pra poder puxar em qualquer lugar do codigo.
	static double totalVendido = 0;
	static int totalPizzasVendidas = 0;
	static int totalCompras = 0;
	static int pizzaNormal = 0;
	static int pizzaDoce = 0;

	// ponto de partida do programa
	public static void main(String[] args) { 

		cadastrarAutomatico(); // cadastrando as 7 pizzas antes do MENU
		menuInicial(); // abre a interface de login
	}

	// Menu da Tela de Login
	private static void menuInicial() {
		int opcao; // variavel na qual armazena a opção escolhida pelo usuario
		do { // estutura utilizada para exibir o menu pelo menos uma vez
			System.out.println(" ");
			System.out.println("===================================");
			System.out.println("           TELA DE LOGIN           ");
			System.out.println("===================================");
			System.out.println(" [1] Cliente");
			System.out.println(" [2] Funcionário");
			System.out.println(" [3] Sair");
			System.out.println("===================================");
			System.out.print(" Escolha uma opção: ");

			opcao = sc.nextInt(); // ler a escolha do usuario
			sc.nextLine(); // limpar o buffer do enter

			if (opcao == 1) { // se opçao escolhida for 1 - entra na interface do menu do Cliente
				menuCliente();
			} else if (opcao == 2) { // se opçao escolhida for 2 - entra na interface do menu do Funcionario
				menuFuncionario();
			} else if (opcao == 3) { // se opçao escolhida for 3 - encerrar sistema
				System.out.println("Encerrando o Sistema...");
			} else { // caso o usuario escolha uma opcao que nao seja de 1-3, ira aparecer a mensagem abaixo
				System.out.println("Opção invalida");
			}

		} while (opcao != 3); // sai do laço, quando opção for 3
	}

	// Tela de Menu do Usuário Cliente
	private static void menuCliente() {
		int opcao; // variavel na qual armazena a opção escolhida pelo usuario
		do { // estutura utilizada para exibir o menu pelo menos uma vez
			System.out.println(""); // espaço apenas para não ficar tudo junto
			System.out.println("===================================");
			System.out.println("           MENU CLIENTE            ");
			System.out.println("===================================");
			System.out.println(" [1] Listar Pizzas");
			System.out.println(" [2] Listar Pizzas Doces");
			System.out.println(" [3] Buscar Pizza");
			System.out.println(" [4] Buscar Pizza Doce");
			System.out.println(" [5] Comprar Pizza");
			System.out.println(" [6] Voltar ao Login");
			System.out.println("===================================");
			System.out.print(" Escolha uma opção: ");

			opcao = sc.nextInt(); // ler a escolha do usuario
			sc.nextLine(); // limpar o buffer do enter

			
			if (opcao == 1) { // se opçao escolhida for 1 - lista todas as Pizzas normais
				listarPizza();
			} else if (opcao == 2) { // se opçao escolhida for 2 - lista todas as Pizzas doces
				listarPizzaDoce();
			} else if (opcao == 3) { // se opçao escolhida for 3 - abre um menu para buscar Pizzas normais por código ou sabor
				buscarPizza();
			} else if (opcao == 4) { // se opçao escolhida for 4 - abre um menu para buscar Pizzas doces por código ou sabor
				buscarPizzaDoce();
			} else if (opcao == 5) { // se opçao escolhida for 5 - abre um menu para comprar qualquer Pizza
				comprarPizza();
			} else if (opcao == 6) { // se opçao escolhida for 6 - volta a tela de login
				System.out.println("Voltando para a tela de Login...");
			} else { // caso o usuario escolha uma opcao que nao seja de 1-6, ira aparecer a mensagem abaixo
				System.out.println("Opção Invalida");
			}
		} while (opcao != 6); // sai do laço, voltando para a tela de login, quando opcao for 6
	}

	// Tela de Menu do Usuário Funcionário
	private static void menuFuncionario() {
		int opcao; // variavel na qual armazena a opção escolhida pelo usuario
		do { // estutura utilizada para exibir o menu pelo menos uma vez
			System.out.println(" "); // espaço apenas para não ficar tudo junto
			System.out.println("==============================================");
			System.out.println("               MENU FUNCIONÁRIO               ");
			System.out.println("==============================================");
			System.out.println(" [1] Cadastrar Pizza");
			System.out.println(" [2] Cadastrar Pizza Doce");
			System.out.println(" [3] Listar Pizzas");
			System.out.println(" [4] Listar Pizzas Doces");
			System.out.println(" [5] Buscar Pizza");
			System.out.println(" [6] Buscar Pizza Doce");
			System.out.println(" [7] Remover Pizza");
			System.out.println(" [8] Remover Pizza Doce");
			System.out.println(" [9] Editar Pizza");
			System.out.println(" [10] Editar Pizza Doce");
			System.out.println(" [11] Ordenar Cardápio por Sabor");
			System.out.println(" [12] Relatório de Vendas");
			System.out.println(" [13] Voltar ao Login");
			System.out.println("==============================================");
			System.out.print(" Escolha uma opção: ");

			opcao = sc.nextInt(); // ler a escolha do usuario
			sc.nextLine(); // limpar o buffer do enter

			if (opcao == 1) { // se opcao escolhida for 1 - abre um menu pra cadastrar novas Pizzas normais
				cadastrarPizza();
			} else if (opcao == 2) { // se opcao escolhida for 2 - abre um menu pra cadastrar novas Pizzas doces
				cadastrarPizzaDoce();
			} else if (opcao == 3) { // se opçao escolhida for 3 - lista todas as Pizzas normais
				listarPizza();
			} else if (opcao == 4) { // se opçao escolhida for 4 - lista todas as Pizzas doces
				listarPizzaDoce();
			} else if (opcao == 5) { // se opçao escolhida for 5 - abre um menu para buscar Pizzas normais por código ou sabor
				buscarPizza();
			} else if (opcao == 6) { // se opçao escolhida for 6 - abre um menu para buscar Pizzas normais por código ou sabor
				buscarPizzaDoce();
			} else if (opcao == 7) { // se opçao escolhida for 7 - abre um menu para remover Pizzas normais do cardapio por código
				removerPizza();
			} else if (opcao == 8) { // se opçao escolhida for 8 - abre um menu para remover Pizzas doces do cardapio por código
				removerPizzaDoce();
			} else if (opcao == 9) { // se opçao escolhida for 9 - abre um menu para editar Pizzas normais, podendo editar apenas um atributo da pizza por vez
				editarPizza();
			} else if (opcao == 10) { // se opçao escolhida for 10 - abre um menu para editar Pizzas doces, podendo editar apenas um atributo da pizza por vez
				editarPizzaDoce();
			} else if (opcao == 11) { // se opcao escolhida for 11 - ordena o cardapio por sabor
				ordenarCardapio();
			} else if (opcao == 12) { // se opcao escolhida for 12 - gera um relatorio do total de vendas do dia
				relatorioVendas();
			} else if (opcao == 13) { // se opçao escolhida for 13 - volta pra tela de login
				System.out.println("Voltando para a tela de Login...");
			} else { // caso o usuario escolha uma opcao que nao seja de 1-13, ira aparecer a mensagem abaixo
				System.out.println("Opção Invalida");
			}

		} while (opcao != 13); // enquanto nao selecionar opção "13" o sistema continua o loop do menu
	}

	// Cadastro Automatico
	private static void cadastrarAutomatico() {
		// cria os objetos pizza e adiciona ao arrayList
		cardapio.add(new Pizza(1, "Calabresa", "calabresa, cebola", 40, "G"));
		cardapio.add(new Pizza(2, "Mussarela", "queijo e tomate", 35, "M"));
		cardapio.add(new Pizza(3, "Frango", "frango e catupiry", 45, "G"));
		cardapio.add(new Pizza(4, "Portuguesa", "presunto, ovo e cebola", 42, "G"));
		cardapio.add(new Pizza(5, "Pepperoni", "pepperoni", 48, "G"));
		cardapio.add(new Pizza(6, "4 Queijos", "mussarela, provolone, parmesão, gorgonzola", 50, "G"));
		cardapio.add(new Pizza(7, "Vegetariana", "verduras variadas", 38, "M"));

		// cria os objetos pizza doce e adiciona ao arrayList
		cardapioDoce.add(new PizzaDoce(101, "Chocolate", "chocolate ao leite", 30, "M", "Granulado", "Calda de chocolate"));
		cardapioDoce.add(new PizzaDoce(102, "Prestígio", "chocolate + coco", 32, "M", "Coco ralado", "Calda de coco"));
	}

	// Cadastrar Pizza Normal
	private static void cadastrarPizza() {
		// declarando as variavel na qual armazena os dados digitados pelo funcionario
		int codigo;
		int continuar;
		String saborPizza;
		String ingredientes;
		double preco;
		String tamanho;

		System.out.println(""); // espaço apenas para não ficar tudo junto
		System.out.println("===================================");
		System.out.println("          CADASTRAR PIZZA          ");
		System.out.println("===================================");

		do { // iniciar o cadastro da pizza
			System.out.print(" Informe o Codigo da Pizza: ");
			codigo = sc.nextInt(); // le o codigo da nova pizza

			System.out.print(" Informe o Sabor da Pizza: ");
			sc.nextLine(); //limpar o buffer do enter
			saborPizza = sc.nextLine(); // le o sabor da nova pizza

			System.out.print(" Informe os Ingredientes da Pizza: ");
			ingredientes = sc.nextLine(); // le os ingredientes da nova pizza

			System.out.print(" Informe Preço da Pizza: ");
			preco = sc.nextDouble(); // le o valor da nova pizza

			System.out.print(" Informe o Tamanho da Pizza (P/M/G): ");
			sc.nextLine(); // limpar o buffer do enter
			tamanho = sc.nextLine(); // le o tamanho da nova pizza

			cardapio.add(new Pizza(codigo, saborPizza, ingredientes, preco, tamanho)); // cria objeto Pizza e adiciona ao ArrayList
			
			System.out.println(""); // espaço apenas para não ficar tudo junto
			System.out.println(" Pizza cadastrada com sucesso.");
			System.out.println(""); // espaço apenas para não ficar tudo junto
			System.out.println(" [1] - Cadastrar outra Pizza | [2] - Voltar ao menu:");

			continuar = sc.nextInt(); // le a resposta
		} while (continuar == 1); // se digitar 1 repete o loop, se for 2 termina e volta ao menu
	}

	// Cadastrar Pizza Doce
	private static void cadastrarPizzaDoce() {
		// declarando as variavel na qual armazena os dados digitados pelo funcionario
		int codigo;
		int continuar;
		String saborPizza;
		String ingredientes;
		double preco;
		String tamanho;
		String coberturaEspecial; // Atributo da Herança
		String calda; // Atributo da Herança

		System.out.println(""); // espaço apenas para não ficar tudo junto
		System.out.println("===================================");
		System.out.println("        CADASTRAR PIZZA DOCE       ");
		System.out.println("===================================");

		do { // iniciar o cadastro da pizza doce
			System.out.print(" Informe o Codigo da Pizza Doce: ");
			codigo = sc.nextInt(); // le o codigo da nova pizza
			
			System.out.print(" Informe o Sabor da Pizza Doce: ");
			sc.nextLine(); //limpar o buffer do enter
			saborPizza = sc.nextLine(); // le o sabor da nova pizza

			System.out.print(" Informe os Ingredientes da Pizza Doce: ");
			ingredientes = sc.nextLine(); // le os ingredientes da nova pizza
			
			System.out.print("Informe Preço da Pizza Doce: ");
			preco = sc.nextDouble(); // le o valor da nova pizza
			
			System.out.print(" Informe o Tamanho da Pizza Doce (P/M/G): ");
			sc.nextLine(); // limpar o buffer do enter
			tamanho = sc.nextLine(); // le o tamanho da nova pizza
			
			System.out.print(" Informe a Corbertura Especial: ");
			coberturaEspecial = sc.nextLine(); // le a cobertura especial da nova pizza
			
			System.out.print(" Informe a Calda: ");
			calda = sc.nextLine(); // le a calda da nova pizza

			cardapioDoce.add(new PizzaDoce(codigo, saborPizza, ingredientes, preco, tamanho, coberturaEspecial, calda)); // cria objeto PizzaDoce e adiciona ao ArrayList

			System.out.println(""); // espaço apenas para não ficar tudo junto
			System.out.println(" Pizza Doce cadastrada com sucesso."); // mensagem de sucesso
			System.out.println(""); // espaço apenas para não ficar tudo junto
			System.out.println(" [1] - Cadastrar outra Pizza | [2] - Voltar ao menu:");


			continuar = sc.nextInt(); // le a resposta
		} while (continuar == 1); // se digitar 1 repete o loop, se for 2 termina e volta ao menu
	}

	// Listar Pizza Normal
	public static void listarPizza() {
		System.out.println("===================================");
		System.out.println("           LISTA DE PIZZA          ");
		System.out.println("===================================");
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println(" |Código    | Sabor           | Valor    | Tamanho    |");
		System.out.println("-------------------------------------------------------");
		
		for (Pizza pizza : cardapio) { // passa pelo arrayList
			
			System.out.printf(" | %-8s | %-15s | %-8.2f | %-10s |\n",
			        // %-8s     → alinhado à esquerda ocupando 8 espaços (código)
			        // %-15s    → alinhado à esquerda ocupando 15 espaços (sabor)
			        // %-8.2f   → número com 2 casas decimais (preço)
			        // %-10s    → alinhado à esquerda ocupando 10 espaços (tamanho)

			        pizza.getCodigo(), // retorna o codigo da pizza
			        pizza.getSaborPizza(), // retorna o nome\sabor da pizza
			        pizza.getPreco(), // retorna o preco da pizza
			        pizza.getTamanho()); // retorna o tamanho da pizza (P/M/G)
		}
	}

	// Listar Pizza Doce
	public static void listarPizzaDoce() {
		System.out.println("===================================");
		System.out.println("        LISTA DE PIZZA DOCE        ");
		System.out.println("===================================");
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println(" |Código    | Sabor           | Valor    | Tamanho    |");
		System.out.println("-------------------------------------------------------");

		for (PizzaDoce pizzadoce : cardapioDoce) { // passa pelo arrayList
			
			System.out.printf(" | %-8s | %-15s | %-8.2f | %-10s |\n",
					// %-8s     → formato: ocupa 8 espaços, alinhado à esquerda
			        // %-15s    → sabor alinhado à esquerda ocupando 15 espaços
			        // %-8.2f   → imprime preço com 2 casas decimais
			        // %-10s    → tamanho ocupando 10 espaços
					
					pizzadoce.getCodigo(), // pega o código da pizza doce
			        pizzadoce.getSaborPizza(), // pega o sabor/nome da pizza doce
			        pizzadoce.getPreco(), // pega o preço da pizza doce
			        pizzadoce.getTamanho()); // pega o tamanho da pizza doce (P/M/G)
		}
	}

	// Buscar Pizza Normal
	public static void buscarPizza() {
		System.out.println("===================================");
		System.out.println("            BUSCAR PIZZA           ");
		System.out.println("===================================");
		System.out.println(" ");
		System.out.print(" Informe o código ou sabor da pizza que deseja buscar: ");

		String criterio = sc.nextLine(); // le o criterio que o usuario digitou (pode ser CODIGO OU SABOR)

		for (Pizza pizza : cardapio) { // passa pelo arrayList
			if (String.valueOf(pizza.getCodigo()).equals(criterio) //compara o codigo digitado com o do arrayList
					|| pizza.getSaborPizza().equalsIgnoreCase(criterio)) { // compara o sabor digitado com o do arrayList (ignorando MAIÚSCULA E MINUSCULA)
				System.out.println(" Pizza Encontrada: " + pizza);
				return; // encerra o metodo assim que encontrar a pizza
			}
		}
		System.out.println(" Pizza não encontrada no cardápio.");
	}

	// Buscar Pizza Doce
	public static void buscarPizzaDoce() {
		System.out.println("===================================");
		System.out.println("          BUSCAR PIZZA DOCE        ");
		System.out.println("===================================");
		System.out.println(" ");
		System.out.print(" Informe o código ou sabor da pizza doce que deseja buscar: ");

		String criterio = sc.nextLine(); // le o criterio que o usuario digitou (pode ser CODIGO OU SABOR)

		for (PizzaDoce pizzadoce : cardapioDoce) { // passa pelo arrayList

			if (String.valueOf(pizzadoce.getCodigo()).equals(criterio) //compara o codigo digitado com o do arrayList
					|| pizzadoce.getSaborPizza().equalsIgnoreCase(criterio)) { // compara o sabor digitado com o do arrayList (ignorando MAIÚSCULA E MINUSCULA)
				System.out.println(" Pizza Doce Encontrada: " + pizzadoce);
				return; // encerra o metodo assim que encontrar a pizza doce
			}
		}
		System.out.println(" Pizza doce não encontrada no cardápio.");
	}

	// Remover Pizza Normal
	private static void removerPizza() {
		System.out.println("===================================");
		System.out.println("           REMOVER PIZZA           ");
		System.out.println("===================================");
		System.out.println("");
		System.out.print(" Informe o código da pizza que deseja remover: ");

		int codigo = sc.nextInt(); //le o codigo digitado pelo usuario
		sc.nextLine(); // limpa o buffer do enter

		for (Pizza pizza : cardapio) { // passa pelo arrayList
			
			if (pizza.getCodigo() == codigo) { // comparar se o codigo da pizza é igual ao digitado pelo usuario
				System.out.print(" Confirmar remoção? (S/N): ");
				String resposta = sc.nextLine(); // le a confirmação do usuario
				
				if (resposta.equalsIgnoreCase("S")) { // compara ignorando maiuscula ou minusccula
					cardapio.remove(pizza); // remove o objeto da lista
					System.out.println(" A Pizza " + pizza + " foi removida.");
				} else {
					System.out.println(" Cancelado.");
				}
				return; 
			}
		}
		System.out.println(" Pizza não encontrada.");
	}

	// Remover Pizza Doce
	private static void removerPizzaDoce() {
		System.out.println("===================================");
		System.out.println("         REMOVER PIZZA DOCE        ");
		System.out.println("===================================");
		System.out.println("");
		System.out.print(" Informe o código da pizza doce que deseja remover: ");

		int codigo = sc.nextInt(); //le o codigo digitado pelo usuario
		sc.nextLine(); // limpa o buffer do enter

		for (PizzaDoce pizzadoce : cardapioDoce) { // passa pelo arrayList
			
			if (pizzadoce.getCodigo() == codigo) { // comparar se o codigo da pizza é igual ao digitado pelo usuario
				System.out.print(" Confirmar remoção? (S/N): ");
				String resposta = sc.nextLine(); // le a confirmação do usuario
				
				if (resposta.equalsIgnoreCase("S")) { // compara ignorando maiuscula ou minusccula
					cardapioDoce.remove(pizzadoce); // remove o objeto da lista
					System.out.println(" A Pizza " + pizzadoce + " foi removida.");
				} else {
					System.out.println(" Cancelada.");
				}
				return;
			}
		}
		System.out.println(" Pizza doce não encontrada.");
	}

	// Editar Pizza
	private static void editarPizza() {
		System.out.println("===================================");
		System.out.println("            EDITAR PIZZA           ");
		System.out.println("===================================");
		System.out.println(" ");
		System.out.print(" Informe o código da Pizza que deseja editar: ");

		int codigo = sc.nextInt(); // le o codgio informado pelo usuario
		sc.nextLine(); // limpa o buffer do enter

		for (Pizza pizza : cardapio) { //passa pelo arrayList
			if (pizza.getCodigo() == codigo) { // verifica se o codigo exite, pra prosseguir a edição

				System.out.println("");
				System.out.println("==============================================");
				System.out.println("           OPÇÕES DE EDIÇÃO DA PIZZA          ");
				System.out.println("==============================================");
				System.out.println(" [1] Alterar Sabor");
				System.out.println(" [2] Alterar Ingredientes");
				System.out.println(" [3] Alterar Preço");
				System.out.println(" [4] Alterar Tamanho");
				System.out.println(" [5] Cancelar Edição");
				System.out.println("==============================================");
				System.out.print(" Escolha uma opção: ");

				int resposta = sc.nextInt(); // le a resposta do usuariio
				sc.nextLine(); // limpa o buffer do enter

				if (resposta == 1) { // se opcao escolhida for 1 - editar o sabor da pizza
					System.out.println(" ");
					System.out.println("===== ALTERAÇÃO DE SABOR =====");
					System.out.print(" Informe o novo sabor: ");
					pizza.setSaborPizza(sc.nextLine()); // atualiza o sabor da pizza no cardapio
					System.out.println(" Sabor atualizado com sucesso!");
					System.out.println(pizza); // imprimi a pizza mostrando que foi devidamente atualizada
				}

				else if (resposta == 2) { // se opcao escolhida for 2 - editar os ingredientes da pizza
					System.out.println(" ");
					System.out.println("===== ALTERAÇÃO DE INGREDIENTES =====");
					System.out.print(" Informe os novos ingredientes: ");
					pizza.setIngredientes(sc.nextLine()); // atualiza os ingredientes da pizza no cardapio
					System.out.println(" Ingredientes atualizados com sucesso!");
					System.out.println(pizza); // imprimi a pizza mostrando que foi devidamente atualizada
				}

				else if (resposta == 3) { // se opcao escolhida for 3 - editar o preco da pizza
					System.out.println(" ");
					System.out.println("===== ALTERAÇÃO DE PREÇO =====");
					System.out.print(" Informe o novo preço: R$ ");
					pizza.setPreco(sc.nextDouble()); // atualiza o preço da pizza no cardapio
					System.out.println(" Preço atualizado com sucesso!");
					System.out.println(pizza); // imprimi a pizza mostrando que foi devidamente atualizada
				}

				else if (resposta == 4) { // se opcao escolhida for 4 - editar o tamanho da pizza
					System.out.println(" ");
					System.out.println("===== ALTERAÇÃO DE TAMANHO =====");
					System.out.print(" Informe o novo tamanho (P/M/G): ");
					pizza.setTamanho(sc.nextLine()); // atualiza o tamanho da pizza no cardapio
					System.out.println(" Tamanho atualizado com sucesso!");
					System.out.println(pizza); // imprimi a pizza mostrando que foi devidamente atualizada
				}

				else if (resposta == 5) { // se opcao escolhida for 5 - cancelar edição da pizza e voltar ao menu
					System.out.println(" ");
					System.out.println("===== EDIÇÃO CANCELADA =====");
					return;
				}

				else {
					System.out.println(" ");
					System.out.println("===== OPÇÃO INVÁLIDA =====");
				}
			}
		}
	}

	// Editar Pizza Doce
	private static void editarPizzaDoce() {

	    System.out.println("===================================");
	    System.out.println("        EDITAR PIZZA DOCE          ");
	    System.out.println("===================================");
	    System.out.println(" ");
	    System.out.print(" Informe o código da Pizza Doce que deseja editar: ");

	    int codigo = sc.nextInt(); // lê o código informado pelo usuário
	    sc.nextLine(); // limpa o buffer do enter

	    for (PizzaDoce pizzadoce : cardapioDoce) { // passa pelo arrayList
	        if (pizzadoce.getCodigo() == codigo) { // verifica se o código existe, para prosseguir a edição

	            System.out.println("");
	            System.out.println("==============================================");
	            System.out.println("        OPÇÕES DE EDIÇÃO DA PIZZA DOCE        ");
	            System.out.println("==============================================");
	            System.out.println(" [1] Alterar Sabor");
	            System.out.println(" [2] Alterar Ingredientes");
	            System.out.println(" [3] Alterar Preço");
	            System.out.println(" [4] Alterar Tamanho");
	            System.out.println(" [5] Alterar Cobertura Especial");
	            System.out.println(" [6] Alterar Calda");
	            System.out.println(" [7] Cancelar Edição");
	            System.out.println("==============================================");
	            System.out.print(" Escolha uma opção: ");

	            int resposta = sc.nextInt(); // lê a resposta do usuário
	            sc.nextLine(); // limpa o buffer do enter

	            if (resposta == 1) { // se opcao escolhida for 1 - editar o sabor da pizza doce 
	                System.out.println(" ");
	                System.out.println("===== ALTERAÇÃO DE SABOR =====");
	                System.out.print(" Informe o novo sabor: ");
	                pizzadoce.setSaborPizza(sc.nextLine()); // atualiza o sabor da pizza doce no cardapio
	                System.out.println(" Sabor atualizado com sucesso!");
	                System.out.println(pizzadoce); // imprimi a pizza doce mostrando que foi devidamente atualizada
	            }

	            else if (resposta == 2) {  // se opcao escolhida for 2 - editar os ingredientes da pizza doce 
	                System.out.println(" ");
	                System.out.println("===== ALTERAÇÃO DE INGREDIENTES =====");
	                System.out.print(" Informe os novos ingredientes: ");
	                pizzadoce.setIngredientes(sc.nextLine()); // atualiza os ingredientes da pizza doce no cardapio
	                System.out.println(" Ingredientes atualizados com sucesso!");
	                System.out.println(pizzadoce); // imprimi a pizza doce mostrando que foi devidamente atualizada
	            }

	            else if (resposta == 3) {  // se opcao escolhida for 3 - editar o preco da pizza doce 
	                System.out.println(" ");
	                System.out.println("===== ALTERAÇÃO DE PREÇO =====");
	                System.out.print(" Informe o novo preço: R$ ");
	                pizzadoce.setPreco(sc.nextDouble()); // atualiza o preço da pizzza doce no cardapio
	                System.out.println(" Preço atualizado com sucesso!");
	                System.out.println(pizzadoce); // imprimi a pizza doce mostrando que foi devidamente atualizada
	            }

	            else if (resposta == 4) {  // se opcao escolhida for 4 - editar o tamanho da pizza doce 
	                System.out.println(" ");
	                System.out.println("===== ALTERAÇÃO DE TAMANHO =====");
	                System.out.print(" Informe o novo tamanho (P/M/G): ");
	                pizzadoce.setTamanho(sc.nextLine()); // atualiza o tamanho da pizza doce no cardapio
	                System.out.println(" Tamanho atualizado com sucesso!");
	                System.out.println(pizzadoce); // imprimi a pizza doce mostrando que foi devidamente atualizada
	            }

	            else if (resposta == 5) {  // se opcao escolhida for 5 - editar a cobertura especial da pizza doce 
	                System.out.println(" ");
	                System.out.println("===== ALTERAÇÃO DE COBERTURA ESPECIAL =====");
	                System.out.print(" Informe a nova cobertura: ");
	                pizzadoce.setCoberturaEspecial(sc.nextLine()); // atualiza a cobertura especial no cardapio
	                System.out.println(" Cobertura atualizada com sucesso!");
	                System.out.println(pizzadoce); // imprimi a pizza doce mostrando que foi devidamente atualizada
	            }

	            else if (resposta == 6) { // se opcao escolhida for 6 - editar a calda da pizza doce 
	                System.out.println(" ");
	                System.out.println("===== ALTERAÇÃO DE CALDA =====");
	                System.out.print(" Informe a nova calda: ");
	                pizzadoce.setCalda(sc.nextLine()); // atualiza a calda da pizza doce no cardapio
	                System.out.println(" Calda atualizada com sucesso!");
	                System.out.println(pizzadoce); // imprimi a pizza doce mostrando que foi devidamente atualizada
	            }

	            else if (resposta == 7) { // se opcao escolhida for 7 - cancelar edição da pizza doce e voltar ao menu
	                System.out.println(" ");
	                System.out.println("===== EDIÇÃO CANCELADA =====");
	                return;
	            }

	            else { // opção inválida
	                System.out.println(" ");
	                System.out.println("===== OPÇÃO INVÁLIDA =====");
	            }
	        }
	    }
	}

	// Ordenar Pizzas do Cardapio
	private static void ordenarCardapio() {
		Collections.sort(cardapio, new Comparator<Pizza>() { 
		/* (Collections.sort) - organiza a lista
		(cardapio) - puxa a lista
		(new Comparator<Pizza> - regra pra comparar objetos pizza*/
			@Override 
			public int compare(Pizza pizza1, Pizza pizza2) {
				return pizza1.getSaborPizza().compareToIgnoreCase(pizza2.getSaborPizza()); 
				/*compareToIgnoreCase() está comparando duas strings e ignorando se esta maiuscula ou minuscula, 
				 * se a pizza1 < pizza2 - retorna negativo assim ficando acima, 
				 * se as duas forem iguais, mantem no mesmo lugar, 
				 * e se pizza1 > pizza2 - retorna positivo assim ficando abaixo */
			}
		});

		System.out.println(" ");
		System.out.println(" Cardápio ordenado por sabor (A → Z).");
		listarPizza();


		Collections.sort(cardapioDoce, new Comparator<PizzaDoce>() {
			/* (Collections.sort) - organiza a lista
			(cardapioDoce) - puxa a lista
			(new Comparator<PizzaDoce> - regra pra comparar objetos pizzadoce*/
			@Override
			public int compare(PizzaDoce pizza1, PizzaDoce pizza2) {
				return pizza1.getSaborPizza().compareToIgnoreCase(pizza2.getSaborPizza());
				/*compareToIgnoreCase() está comparando duas strings e ignorando se esta maiuscula ou minuscula, 
				 * se a pizza1 < pizza2 - retorna negativo assim ficando acima, 
				 * se as duas forem iguais, mantem no mesmo lugar, 
				 * e se pizza1 > pizza2 - retorna positivo assim ficando abaixo */
			}
		});

		System.out.println(" ");
		System.out.println(" Cardápio ordenado por sabor (A → Z).");
		listarPizzaDoce();
	}


	// Comprar Pizza
	private static void comprarPizza() { // metodo criado para comprar pizza
		
		//menu inicial de compra
		System.out.println("");
		System.out.println("===================================");
		System.out.println("            COMPRAR PIZZA          ");
		System.out.println("===================================");
		System.out.println(" [1] Pizza Normal");
		System.out.println(" [2] Pizza Doce");
		System.out.println("===================================");
		System.out.print(" Escolha uma opção: ");

		int opcao = sc.nextInt(); // le a opcao digitada pelo usuario
		sc.nextLine(); // limpa o buffer do enter

		// mostra o cardapio disponivel para comprar, conforme escolha do usuario
		if (opcao == 1) {
			listarPizza();
		} else if (opcao == 2) {
			listarPizzaDoce();
		} else if (opcao != 1 && opcao != 2) { // se as opçoes nao forem 1 ou 2 irá retornar como invalido
			System.out.println("\n===== OPÇÃO INVÁLIDA =====");
			return;
		}

		// buscar a pizza desejada
		System.out.println("");
		System.out.print(" Informe o Código ou Sabor desejado: ");
		String criterio = sc.nextLine(); // le o codigo ou sabor da pizza  desejada

		// variaveis para armazenar os dados quando a pizza for encontrada
		String sabor = "";
		double preco = 0;
		boolean encontrada = false;

		// Buscar no cardapio pizza normal
		if (opcao == 1) { // se opcao escolhida for 1 - entra no laço de pizza normal
			for (Pizza pizza : cardapio) { // passa pelo arrayList
				if (String.valueOf(pizza.getCodigo()).equals(criterio)
						|| pizza.getSaborPizza().equalsIgnoreCase(criterio)) {
					
					sabor = pizza.getSaborPizza(); // armazena o sabor encontrado 
					preco = pizza.getPreco(); // armazena o preço encontrado
					encontrada = true; // confirma que encontrou a pizza
					break; // para a busca pela pizza
				}
			}
		}


		// Buscarno cardapio a pizza doce
		else if (opcao == 2) { // se opcao escolhida for 2 - entra no loço de pizza doce
			for (PizzaDoce pizzadoce : cardapioDoce) { // passa pelo arrayList
				if (String.valueOf(pizzadoce.getCodigo()).equals(criterio)
						|| pizzadoce.getSaborPizza().equalsIgnoreCase(criterio)) {
					
					sabor = pizzadoce.getSaborPizza(); // armazena o sabor encontrado
					preco = pizzadoce.getPreco(); // armazena o preço encontrado
					encontrada = true; // confirma que encontrou a pizza
					break; // para a busca pela pizza
				}
			}
		}


		if (!encontrada) { // se for diferente da variavel ‘’encontrada’’ o sistema irá retornar como não encontrada
			System.out.println("\n===== PIZZA NÃO ENCONTRADA =====");
			return;
		}

		// quantidade desejada 
		System.out.println(" ");
		System.out.print(" Informe a quantidade desejada: ");
		int qtd = sc.nextInt(); // ler a quantidade informada
		sc.nextLine(); // limpa o buffer do enter

		// valida a quantidade, pra não quebrar o codigo e a pessoa conseguir comprar 0 quantidades
		if (qtd <= 0) {
			System.out.println("\n===== QUANTIDADE INVÁLIDA =====");
			return;
		}

		double total = preco * qtd; // calcula o valor total da compra

		// seleção da forma de pagamento
		System.out.println(" ");
		System.out.println("===================================");
		System.out.println("        FORMA DE PAGAMENTO         ");
		System.out.println("===================================");
		System.out.println(" [1] PIX");
		System.out.println(" [2] Débito");
		System.out.println(" [3] Crédito");
		System.out.println(" [4] Dinheiro");
		System.out.println("===================================");
		System.out.print(" Escolha uma opção: ");

		int formaPagamento = sc.nextInt(); // ler por qual forma o usuario ira pagar
		sc.nextLine(); // limpar o buffer doo enter

		String pagamento = ""; // variavel que ira armazena a forma de pagamento

		if (formaPagamento == 1) {
			pagamento = "PIX";
		} else if (formaPagamento == 2) {
			pagamento = "Débito";
		} else if (formaPagamento == 3) {
			pagamento = "Crédito";
		} else if (formaPagamento == 4) {
			pagamento = "Dinheiro";
		} else {
			System.out.println("Forma de Pagamento Desconhecida");
			return;
		}

		// resumo final do pedido
		System.out.println(" ");
		System.out.println("===================================");
		System.out.println("              PEDIDO               ");
		System.out.println("===================================");
		System.out.println(" Pizza: " + sabor);
		System.out.println(" Quantidade: " + qtd);
		System.out.println(" Preço unitário: R$ " + preco);
		System.out.println(" Total: R$ " + total);
		System.out.println(" Pagamento: " + pagamento);
		System.out.println("===================================");
		System.out.println(" Pedido Concluído com Sucesso!");
		System.out.println("===================================");

		// informações pra atualiza o relatorio de vendas do dia
		totalVendido += total; // soma ao total vendido
		totalPizzasVendidas += qtd; // soma ao total de pizzas vendidas
		totalCompras++; // atualiza como uma nova compra

		// verifica se foi normal ou doce, e depois soma ao valor existente
		if (opcao == 1) {
			pizzaNormal += qtd;
		} else {
			pizzaDoce += qtd;
		}
	}

	// Relatório das Vendas do Dia
	private static void relatorioVendas() {


		System.out.println(" ");
		System.out.println("==============================================");
		System.out.println("            RELATÓRIO DE VENDAS DO DIA        ");
		System.out.println("==============================================");
		// mostra o valor total arrecadado com vendas
		System.out.println(" Total Vendido:                R$ " + totalVendido);
		// mostra a quantidade total de pizzas vendidas (normal + doce)
		System.out.println(" Total de Pizzas Vendidas:     " + totalPizzasVendidas);
		// mostra quantas compras foram realizadas no sistema
		System.out.println(" Total de Compras Realizadas:  " + totalCompras);
		System.out.println(" ");
		System.out.println(" ----- Detalhamento por Tipo de Pizza ----- ");
		// mostra quantas pizzas normais foram vendidas
		System.out.println(" Normais Vendidas:             " + pizzaNormal);
		// mostra quantas pizzas doces foram vendidas
		System.out.println(" Doces Vendidas:               " + pizzaDoce);
		System.out.println("==============================================");
	}
}