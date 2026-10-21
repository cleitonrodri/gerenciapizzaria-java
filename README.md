# 🍕 Sistema de Gerenciamento de Pizzaria (Java)

Aplicação de console em Java para gerenciar o cardápio e as vendas de uma pizzaria. Foi um dos primeiros projetos de Programação Orientada a Objetos na faculdade (Sistemas de Informação, UNIFACS), desenvolvido em dupla.

O sistema tem dois perfis. O **cliente** consulta o cardápio e compra pizzas. O **funcionário** cadastra, edita e remove pizzas e consulta o relatório de vendas do dia.

## Funcionalidades

**Cliente**
- Listar pizzas normais e pizzas doces
- Buscar pizza por código ou por sabor
- Comprar pizza: escolhe o tipo, a pizza, a quantidade e a forma de pagamento (PIX, débito, crédito ou dinheiro). O sistema mostra o resumo do pedido com o total.

**Funcionário**
- Cadastrar pizzas normais e doces
- Listar e buscar pizzas
- Editar uma pizza, um atributo por vez
- Remover pizza por código
- Ordenar o cardápio por sabor, de A a Z
- Relatório de vendas do dia: total vendido, total de pizzas, número de compras e divisão entre normais e doces

Ao iniciar, o sistema já cadastra 7 pizzas normais e 2 pizzas doces, para testar sem digitar nada.

## Conceitos de programação aplicados

- **Herança:** `PizzaDoce` estende `Pizza` e acrescenta cobertura especial e calda.
- **Encapsulamento:** atributos privados, com getters e setters.
- **Polimorfismo:** `toString()` sobrescrito nas duas classes. A versão de `PizzaDoce` reaproveita a da classe mãe com `super.toString()`.
- **Coleções:** `ArrayList` separados para pizzas normais e doces.
- **Ordenação:** `Collections.sort` com `Comparator`, ignorando maiúsculas e minúsculas.
- **Menus com laços** `do/while` e leitura de dados com `Scanner`.

## Estrutura do projeto

```
gerenciapizzaria/
└── src/
    ├── aplicacao/
    │   └── Programa.java      # menus, compra e relatório de vendas
    └── Entidades/
        ├── Pizza.java         # classe mãe
        └── PizzaDoce.java     # classe filha
```

## Como executar

Pré-requisito: JDK 21 ou superior. O projeto foi criado no Eclipse com Java 21.

**Pelo terminal**, a partir da pasta `gerenciapizzaria`:

```bash
mkdir bin
javac -encoding UTF-8 -d bin src/Entidades/*.java src/aplicacao/*.java
java -Dstdout.encoding=UTF-8 -cp bin aplicacao.Programa
```

O parâmetro `-Dstdout.encoding=UTF-8` evita acentos quebrados no terminal.

**Pelo VS Code:**

1. Instale o JDK 21 ou superior.
2. Instale a extensão [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack), da Microsoft.
3. Abra a pasta `gerenciapizzaria` com *File → Open Folder*. Abra a pasta `gerenciapizzaria`, e não a raiz do repositório, para o VS Code reconhecer a pasta `src`.
4. Abra o arquivo `src/aplicacao/Programa.java`.
5. Clique em **Run** (acima do método `main`) ou use o botão ▷ no canto superior direito.
6. Digite as opções do menu no painel **Terminal**, que abre na parte de baixo da tela.

**Pelo Eclipse:** use *File → Import → Existing Projects into Workspace*, selecione a pasta `gerenciapizzaria` e execute `Programa.java`.

## Limitações conhecidas

- Os dados ficam só na memória. Ao fechar o programa, o cardápio volta ao padrão e as vendas do dia são perdidas.
- Não há login. O menu de funcionário abre para qualquer pessoa.
- Digitar letras onde se espera um número encerra o programa com erro, porque a entrada não é validada.
- O relatório de vendas guarda apenas os totais do dia, sem histórico de cada pedido.

## Próximos passos

1. Tratar entradas inválidas com `try/catch`.
2. Salvar o cardápio e as vendas em arquivo ou em banco de dados.
3. Adicionar senha para o acesso do funcionário.
4. Registrar cada pedido, com data e forma de pagamento.

## Autores

Projeto desenvolvido em dupla. Todas as etapas foram feitas em conjunto, sem divisão de tarefas.

- **Cleiton Rodrigues** – [GitHub](https://github.com/cleitonrodri) · [LinkedIn](https://www.linkedin.com/in/cleiton-rodrigues-ti/)
- **Leonardo Oliveira** – [GitHub](https://github.com/leoxsantos)
