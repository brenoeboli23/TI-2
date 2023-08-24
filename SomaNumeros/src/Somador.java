import java.util.*;


public class Somador {
	public static int somaNumeros(int num1, int num2) {
		return num1+num2;
	}
	
	public static void main(String args[]) {
		System.out.println("Digite um numero: ");
		Scanner leitor = new Scanner(System.in);
		int num1 = leitor.nextInt();
		System.out.println("Digite outro numero: ");
		int num2 = leitor.nextInt();
		leitor.close();
		System.out.println("Soma dos numeros digitados: "+somaNumeros(num1, num2));
	}
}
