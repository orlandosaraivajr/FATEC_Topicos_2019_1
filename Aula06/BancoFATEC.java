import java.util.Scanner;

class ContaPoupanca {
	double saldo;

	public ContaPoupanca() {
		this.saldo = 0.01;
	}
	
	public ContaPoupanca(double saldo_inicial) {
		this.saldo = saldo_inicial;
	}

	public ContaPoupanca(String string_valor) {
		double saldo_inicial = Double.parseDouble(string_valor);
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

	public double saldo() {
		return this.saldo;
	}
}

class ContaCorrente {
	double saldo = 0.0;

	public void depositar(double valor) {
		System.out.printf("Valor depositado =  %f \n", valor);
		this.saldo = this.saldo + valor;
	}
	
	public void saque(double valor) {
		System.out.printf("Valor sacado =  %f \n", valor);
		this.saldo = this.saldo - valor;
	}
	
	public double saldo() {
		return this.saldo;
	}
}

public class BancoFATEC {
    public static void main ( String[] args) {
		double riqueza_do_Orlando = 0;
		
		System.out.println("Conta Corrente ");
		ContaCorrente conta_do_Orlando = new ContaCorrente();
		conta_do_Orlando.depositar(500.00);
		conta_do_Orlando.depositar(200.00);
		conta_do_Orlando.saque(100.00);
		System.out.printf("Saldo atual =  %f \n", conta_do_Orlando.saldo());
		
		System.out.println("************************************************************");
		System.out.println("Conta Poupanca ");
		ContaPoupanca poupanca_do_Orlando = new ContaPoupanca("30");
		// poupanca_do_Orlando.depositar(1000);
		// poupanca_do_Orlando.depositar(1000.00);
		// poupanca_do_Orlando.depositar("1000");
		
		poupanca_do_Orlando.rendimento(0.5);
		poupanca_do_Orlando.rendimento(0.5);
		// poupanca_do_Orlando.resgatar(100.00);
		System.out.printf("Saldo atual =  %f \n", poupanca_do_Orlando.saldo());
		System.out.println("************************************************************");
		
		riqueza_do_Orlando = poupanca_do_Orlando.saldo() + conta_do_Orlando.saldo();
		System.out.printf("O total de ativos do Orlando =  %f \n", riqueza_do_Orlando);
    }
}