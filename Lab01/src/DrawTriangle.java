import java.util.Scanner;
public class DrawTriangle {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Input the height:");
		int n = scanner.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n-i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			for(int j = 1; j <= n-i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
