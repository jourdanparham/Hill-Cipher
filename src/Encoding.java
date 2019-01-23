import java.util.Scanner;

public class Encoding {
	/**
	 * @author Jourdan Parham
	 */

	public static void main(String[] args) {
		decode();

}
	
	public static void decode() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 'a' value: ");
		int a = sc.nextInt();
		System.out.println("Enter 'b' value: ");
		int b = sc.nextInt();
		System.out.println("Enter 'c' value: ");
		int c = sc.nextInt();
		System.out.println("Enter 'd' value: ");
		int d = sc.nextInt();
		System.out.println("Enter mod value: ");
		int mod = sc.nextInt();
		
		// Generates the 2x2 array, encoding matrix
		System.out.println("Encoding Matrix: ");
		int matrix [][] = 
			{
					{a, b},
					{c, d}	
		};
		
		for (int i = 0; i < matrix.length; i++) { 
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		
		// generate the inverse
		int denom = (a*d) - (b*c);
		int ans;
		int inverse = 0;
		
		// denominator^i
		for (int i = 1; i < 5; i++) {
			ans = (int) Math.pow(denom, i);
			
			// if denom^i mod 26 equals 1, then return denominator^i-1
			if (ans % mod == 1) {
//				System.out.println("Answer: " + ans);
//				System.out.println("i value: " + i);
				
				inverse = (int) Math.pow(denom, i - 1);
				inverse = inverse % mod;
				System.out.println("Inverse: " + inverse);
				System.out.println();
				
			}
		}
		
		// decoding matrix
		int decodeMatrix [][] = 
			{
					{d, -b},
					{-c, a}	
		};
		
		System.out.println("Decoding Matrix: ");
		// iterate through 2d array and multiply inverse by matrix
		for (int i = 0; i < decodeMatrix.length; i++) { 
			for (int j = 0; j < decodeMatrix[i].length; j++) {
				System.out.print(decodeMatrix[i][j] * inverse + " ");
			}
			System.out.println();
			
		}
		
	}
	}
