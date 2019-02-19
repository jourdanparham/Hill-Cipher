import java.util.HashMap;
import java.util.Scanner;

public class Encoding {
	/**
	 * @author Jourdan Parham
	 */

	public static void main(String[] args) {
		decode();
		encode();

}
	
	public static void decode() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter 'a' value: ");
//		int a = sc.nextInt();
//		System.out.println("Enter 'b' value: ");
//		int b = sc.nextInt();
//		System.out.println("Enter 'c' value: ");
//		int c = sc.nextInt();
//		System.out.println("Enter 'd' value: ");
//		int d = sc.nextInt();
//		System.out.println("Enter mod value: ");
//		int mod = sc.nextInt();
//		
//		// Generates the 2x2 array, encoding matrix
//		System.out.println("Encoding Matrix: ");
//		int matrix [][] = 
//			{
//					{a, b},
//					{c, d}	
//		};
//		
//		for (int i = 0; i < matrix.length; i++) { 
//			for (int j = 0; j < matrix[i].length; j++) {
//				System.out.print(matrix[i][j] + "  ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		
//		// gcd of mod # and denom(determinant) to be 1 
//		// invalid encoding matrix - make it dynamic
//		
//		
//		// generate the inverse
//		int denom = (a*d) - (b*c);
//		int ans;
//		int inverse = 0;
//		
//		// denominator^i
//	  //the greatest i can be is mod
//		for (int i = 1; i < mod; i++) {
//			// theoretically using denom^i works but its doesn't work programatically
//			ans = i * denom;
//			
//			// if denom^i mod 26 equals 1, then return denominator^i-1
//			if (ans % mod == 1) {
////				System.out.println("Answer: " + ans);
////				System.out.println("i value: " + i);
//				
//				inverse = i;
//				inverse = inverse % mod;
//				System.out.println("Inverse: " + inverse);
//				System.out.println();
//				
//			}
//		}
//		
//		// decoding matrix
//		int decodeMatrix [][] = 
//			{
//					{d, -b},
//					{-c, a}	
//		};
//		
//		System.out.println("Decoding Matrix: ");
//		// iterate through 2d array and multiply inverse by matrix
//		for (int i = 0; i < decodeMatrix.length; i++) { 
//			for (int j = 0; j < decodeMatrix[i].length; j++) {
//				System.out.print((decodeMatrix[i][j] * inverse  % mod + mod) % mod + " ");
//			}
//			System.out.println();
//			
//		}
		
	}
	
	public static void encode() {
		// split string into characters
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter message: ");
		String phrase = sc.nextLine();
		
		System.out.println("Enter 'a' value: ");
		int a = sc.nextInt();
		System.out.println("Enter 'b' value: ");
		int b = sc.nextInt();
		System.out.println("Enter 'c' value: ");
		int c = sc.nextInt();
		System.out.println("Enter 'd' value: ");
		int d = sc.nextInt();
		
		String[] character = phrase.split("");
		for(int i = 0; i < character.length; i++) {
			System.out.println(character[i]);
			
			// use char to convert to unicode
//			char ch = phrase.charAt(i);
//			int pos = ch;
//			System.out.println(pos);
			
		
			
//			pos = pos + 32;
			
//			System.out.println((char)65);
		
			
		}
		
		// converted to unicode
		int[] position = new int [character.length];
		
		for(int i= 0; i < position.length; i++) {
			position[i] = phrase.charAt(i);
//			System.out.println(position[i]);
			
			// convert letters to numbers by adding 32
			// mod by 26
			position[i] = (position[i] + 33) % 26;
			System.out.println(position[i]);
				
		}
		
		
		
		// matrix multiplication
		int elem1 = a * position[0];
		System.out.println(elem1);
		
		
		
		
		
		
		
		// encoding matrix check for no multiples of 5 or 19
		int encodingMatrix [][] = 
				{
						{a, b},
						{c, d}	
			};
		
		
		// 0 - 94
		// check for divisibility using % no multiples of 5 or 19
		
		
		// check the string itself
		
		// change to matrix position
		
		// mod 95
		
		// convert back by adding 32
		
		

		
		
		// split array to string
		
		
//		Scanner sc2 = new Scanner(System.in);
//		System.out.println("Enter phrase to encode: ");
//		String phrase = sc2.nextLine();
//		
//		System.out.println("Enter mod value: ");
//		int mod = sc2.nextInt();

	

//	}
	
	}
}
