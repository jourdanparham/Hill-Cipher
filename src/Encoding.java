import java.util.Arrays;
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
			
			// use char to convert to unicode - unadjusted
			char ch = phrase.charAt(i);
			int pos = ch;
//			System.out.println(pos);
			
		
			
			pos = pos + 32;
			
//			System.out.println("CHAR 65 " + (char)65);
		
			
		}
		
		// converted to unicode
		int[] position = new int [character.length];
		
		for(int i= 0; i < position.length; i++) {
			position[i] = phrase.charAt(i);
			
			System.out.println("POS i " + position[i]);
			// convert letters to numbers by subtracting 32 0 - 94; largest symbol is 94
//			position[i] = position[i] - 32;
//			System.out.println(position[i] - 32);
			// add 32 back later
			
			
//			position[i] = ((position[i] - 32) % 126 - 32 + 1);
			
//			System.out.println(((position[i] - 32) % 126 - 32 + 1));
			
			// mod by 26
//			System.out.println(position[i]);
				
		}
		
		// matrix multiplication
		// if even: block size 2
		// if odd: add 0 to end of the last block
		int[] elem1 = new int [2];
		int[] elem2 = new int [2];
		int pos = 0;
		
		if (phrase.length() % 2 == 0) {
			for (int i= 0; i < position.length; i = i+2) {
				elem1[pos] = (a * position[i]) + (b * position[i+1]);
				elem2[pos] = (c * position[i]) + (d * position[i+1]);
				pos++;
			}
		}
		
		System.out.println(Arrays.toString(elem1));

		
		
		
		
		
		
		// matrix multiplication
//		int elem1 = a * position[0];
//		System.out.println(elem1);
		
		
		
		
		
		
		
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
