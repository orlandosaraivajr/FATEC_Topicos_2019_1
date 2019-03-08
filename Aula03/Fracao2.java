import java.util.Scanner;

class Fracao {
	Scanner input = new Scanner(System.in);
	int numerador;
	int denominador;
	int fracao;

	public void set_numerador() {
		System.out.println("Digite o numerador : ");
		this.numerador = input.nextInt();

	}
	
	public void set_denominador() {
		System.out.println("Digite o denominador : ");
		this.denominador = input.nextInt();
	}
	
	public float fracao() {
		return numerador/denominador;
	}
}

public class Fracao2 {
    public static void main ( String[] args) {
		Fracao fracao = new Fracao();
		fracao.set_numerador();
		fracao.set_denominador();
		System.out.printf("A fracao =  %f \n", fracao.fracao());
    }
}