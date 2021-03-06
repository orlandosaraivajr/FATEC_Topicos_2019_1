import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class ContaPoupanca {
	private String nome_titular;
	private String numero_conta;
	private double saldo;

	public ContaPoupanca() {
		this.nome_titular = "";
		this.numero_conta = "";
		this.saldo = 0.01;
	}

	public ContaPoupanca(String nome, String conta, double saldo_inicial) {
		this.nome_titular = nome;
		this.numero_conta = conta;
		this.saldo = saldo_inicial;
	}

	public void depositar(double valor) {
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}

	public void depositar(String string_valor) {
		double valor = Double.parseDouble(string_valor);
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}

	public void resgatar(double valor) {
		System.out.printf("Valor sacado =  %f \n", valor);
		this.saldo = this.saldo - valor;
	}

	public void rendimento(double porcentagem) {
		porcentagem = porcentagem / 100;
		this.saldo = this.saldo + (this.saldo * porcentagem);
	}

	public double getSaldo() {
		return this.saldo;
	}

	public String getNumeroConta() {
		return this.numero_conta;
	}

	public String getNomeTitular() {
		return this.nome_titular;
	}
}

class ContaCorrente {
	private String nome_titular;
	private String numero_conta;
	private double saldo;

	public ContaCorrente() {
		this.nome_titular = "";
		this.numero_conta = "";
		this.saldo = 0.01;
	}

	public ContaCorrente(String nome, String conta, double saldo_inicial) {
		this.nome_titular = nome;
		this.numero_conta = conta;
		this.saldo = saldo_inicial;
	}

	public void depositar(double valor) {
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}

	public void saque(double valor) {
		System.out.printf("Valor sacado =  %f \n", valor);
		this.saldo = this.saldo - valor;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public String getNumeroConta() {
		return this.numero_conta;
	}

	public String getNomeTitular() {
		return this.nome_titular;
	}
}

class CarteiraClientes {
	ArrayList<ContaPoupanca> poupadores = new ArrayList<>();
	ArrayList<ContaCorrente> correntistas = new ArrayList<>();

	public CarteiraClientes() {

	}

	public void criarConta(String nome, String numero_conta, int tipo, double valor) {
		if (tipo == 0) {
			ContaPoupanca nova_poupanca = new ContaPoupanca(nome, numero_conta, valor);
			this.poupadores.add(nova_poupanca);
		} else {
			ContaCorrente nova_conta = new ContaCorrente(nome, numero_conta, valor);
			this.correntistas.add(nova_conta);
		}
		System.out.println(correntistas);
		System.out.println(poupadores);
	}

	public void depositar(String numero_conta, int tipo, double valor) {
		if (tipo == 1) {
			ContaCorrente conta_encontrada = this.encontrar_conta_corrente(numero_conta);
			conta_encontrada.depositar(valor);
		} else {
			ContaPoupanca conta_encontrada = this.encontrar_conta_poupanca(numero_conta);
			conta_encontrada.depositar(valor);
		}
	}

	public void sacar(String numero_conta, int tipo, double valor) {
		if (tipo == 1) {
			ContaCorrente conta_encontrada = this.encontrar_conta_corrente(numero_conta);
			conta_encontrada.saque(valor);
		} else {
			ContaPoupanca conta_encontrada = this.encontrar_conta_poupanca(numero_conta);
			conta_encontrada.resgatar(valor);
		}
	}

	public ContaCorrente encontrar_conta_corrente(String numero_conta) {
		ContaCorrente conta_encontrada = null;
		for ( int x = 0; x < this.correntistas.size(); x++) {
			if (Objects.equals(correntistas.get(x).getNumeroConta(), numero_conta)) {
				conta_encontrada = correntistas.get(x);
				System.out.println("\n\n===================================");
				System.out.println("Dados Encontrados");
				System.out.println("===================================");
				System.out.println(conta_encontrada.getNomeTitular());
				System.out.println(conta_encontrada.getNumeroConta());
				System.out.println(conta_encontrada.getSaldo());
				System.out.println("===================================\n\n");
			}
		}
		return conta_encontrada;
	}

	public ContaPoupanca encontrar_conta_poupanca(String numero_conta) {
		ContaPoupanca conta_encontrada = null;
		for ( int x = 0; x < this.poupadores.size(); x++) {
			if (Objects.equals(poupadores.get(x).getNumeroConta(), numero_conta)) {
				conta_encontrada = poupadores.get(x);
				System.out.println("\n\n===================================");
				System.out.println("Dados Encontrados");
				System.out.println("===================================");
				System.out.println(conta_encontrada.getNomeTitular());
				System.out.println(conta_encontrada.getNumeroConta());
				System.out.println(conta_encontrada.getSaldo());
				System.out.println("===================================\n\n");
			}
		}
		return conta_encontrada;
	}

	public void aniversario_poupanca(double rendimento) {
		ContaPoupanca conta_encontrada = null;
		for ( int x = 0; x < this.poupadores.size(); x++) {
			conta_encontrada = poupadores.get(x);
			conta_encontrada.rendimento(rendimento);
			System.out.println("Poupanca rendeu:");
			System.out.println(conta_encontrada.getNomeTitular());
			System.out.println(conta_encontrada.getSaldo());
			System.out.println("\n\n");
		}
	}
}

public class BancoFATEC {
    public static void main ( String[] args) {
		CarteiraClientes agencia_Araras = new CarteiraClientes();
		Console console = System.console();
		Scanner input = new Scanner(System.in);
		double movimentacao = 0;
		String numero_conta = "0";
		int opcao = 10;
		do {
			System.out.println("Banco FATEC");
			System.out.println("============");
			System.out.println("1.\t Criar uma conta");
			System.out.println("**********************************");
			System.out.println("2.\t Deposito em conta corrente");
			System.out.println("3.\t Saque em conta corrente");
			System.out.println("4.\t Encontrar Conta Corrente");
			System.out.println("**********************************");
			System.out.println("5.\t Deposito em conta poupanca");
			System.out.println("6.\t Saque em conta  poupanca");
			System.out.println("7.\t Encontrar conta poupanca");
			System.out.println("8.\t Aniversario da poupanca");
			System.out.println("**********************************");
			System.out.println("0.\t Encerrar sistema");
			opcao = input.nextInt();

			if (opcao == 1) {
				System.out.println("Digite o nome do cliente: ");
				String nome_cliente = console.readLine();
				System.out.println("Digite 1 para Conta Corrente, 0 para Poupança: ");
				int tipo =  input.nextInt();
				System.out.println("Digite o número da conta: ");
				numero_conta = console.readLine();
				System.out.println("Digite o valor a se depositar: ");
				movimentacao = input.nextDouble();
				agencia_Araras.criarConta(nome_cliente, numero_conta, tipo, movimentacao);
			}

			if (opcao == 2) {
				System.out.println("Digite o número da conta corrente: ");
				numero_conta = console.readLine();
				System.out.println("Digite o valor para depositar: ");
				movimentacao = input.nextDouble();
				agencia_Araras.depositar(numero_conta, 1, movimentacao);
			}

			if (opcao == 3) {
				System.out.println("Digite o número da conta corrente: ");
				numero_conta = console.readLine();
				System.out.println("Digite o valor que deseja sacar: ");
				movimentacao = input.nextDouble();
				agencia_Araras.sacar(numero_conta, 1, movimentacao);
			}

			if (opcao == 4) {
				System.out.println("Digite o número da conta: ");
				numero_conta = console.readLine();
				agencia_Araras.encontrar_conta_corrente(numero_conta);
			}

			if (opcao == 5) {
				System.out.println("Digite o número da conta poupanca: ");
				numero_conta = console.readLine();
				System.out.println("Digite o valor para depositar: ");
				movimentacao = input.nextDouble();
				agencia_Araras.depositar(numero_conta, 0, movimentacao);
			}
			if (opcao == 6) {
				System.out.println("Digite o número da conta corrente: ");
				numero_conta = console.readLine();
				System.out.println("Digite o valor que deseja sacar: ");
				movimentacao = input.nextDouble();
				agencia_Araras.sacar(numero_conta, 0, movimentacao);
			}
			if (opcao == 7) {
				System.out.println("Digite o número da conta: ");
				numero_conta = console.readLine();
				agencia_Araras.encontrar_conta_poupanca(numero_conta);
			}
			if (opcao == 8) {
				System.out.println("Digite a porcentagem de juros que a poupanca rendeu: ");
				movimentacao = input.nextDouble();
				agencia_Araras.aniversario_poupanca(movimentacao);
			}
		} while ( opcao != 0 );

		System.out.println("****************************************");
		System.out.println("\t\t Banco FATEC");
		System.out.println("\t\t Volte Sempre !");
		System.out.println("****************************************");


    }
}
