
import java.util.Scanner;

public class Comparativo {
    public static void main ( String[] args) {
		Scanner input = new Scanner(System.in);
		int numero1;
		int numero2;
		int maior = 0;
		System.out.println("Digite o primeiro numero: ");
		numero1 = input.nextInt();
		System.out.println("Digite o segundo numero: ");
		numero2 = input.nextInt();
		if (numero1 > numero2) {
			maior = numero1;
		}
		if (numero2 > numero1) {
			maior = numero2;
		}
		if (numero2 == numero1) {
			System.out.println("Numeros identicos \n");
		} else {
			System.out.printf("Maior numero =  %d \n", maior);
		}
		
    }
}