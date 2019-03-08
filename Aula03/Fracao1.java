import java.util.Scanner;

public class Fracao1 {
    public static void main ( String[] args) {
		Scanner input = new Scanner(System.in);
		int numerador;
		int denominador;
		int fracao;
		System.out.println("Digite o numerador : ");
		numerador = input.nextInt();
		System.out.println("Digite o denominador : ");
		denominador = input.nextInt();
		fracao = numerador / denominador;
		System.out.printf("A fracao =  %d \n", fracao);
    }
}