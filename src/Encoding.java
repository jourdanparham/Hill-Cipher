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
		
		int[] matrix = new int[10];
		matrix = encode();
		System.out.println("The matrix: " + Arrays.toString(matrix));
		
		String phrase = "math";
		int[] encodedPhrase = new int [phrase.length()];
		
		int a = 15;
		int b = 51;
		int c = 73;
		int d = 66;
		
		
		for (int i= 0; i < matrix.length; i = i+2) {
			encodedPhrase[i] = ((((a * matrix[i]) + (b * matrix[i+1])) % 95) + 32);
			encodedPhrase[i+1] = ((((c * matrix[i]) + (d * matrix[i+1])) % 95) + 32);
		}
		
		System.out.println("the main: " + Arrays.toString(encodedPhrase));
		
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
		
		int a = 3;
		int b = 2;
		int c = 1;
		int d = 5;
		
		int mod = 95;
		
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
		
		
		// gcd of mod # and denom(determinant) to be 1 
		// invalid encoding matrix - make it dynamic
		
		
		// generate the inverse
		int denom = (a*d) - (b*c);
		int ans;
		int inverse = 0;
		
		// denominator^i
	  //the greatest i can be is mod
		for (int i = 1; i < mod; i++) {
			// theoretically using denom^i works but its doesn't work programatically
			ans = i * denom;
			
			// if denom^i mod 26 equals 1, then return denominator^i-1
			if (ans % mod == 1) {
//				System.out.println("Answer: " + ans);
//				System.out.println("i value: " + i);
				
				inverse = i;
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
				System.out.print((decodeMatrix[i][j] * inverse  % mod + mod) % mod + " ");
			}
			System.out.println();
			
		}
		
//			for (int i= 0; i < position.length; i = i+2) {
//				encodedPhrase[i] = (char)((((a * position[i]) + (b * position[i+1])) % 95) + 32);
//				encodedPhrase[i+1] = (char)((((c * position[i]) + (d * position[i+1])) % 95) + 32);
//
//			}
	
		
		
	}
	
	public static int[] encode() {
		// split string into characters
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter message: ");
//		String phrase = sc.nextLine();
		
//		System.out.println("Enter 'a' value: ");
//		int a = sc.nextInt();
//		System.out.println("Enter 'b' value: ");
//		int b = sc.nextInt();
//		System.out.println("Enter 'c' value: ");
//		int c = sc.nextInt();
//		System.out.println("Enter 'd' value: ");
//		int d = sc.nextInt();
		
		String phrase = "math";
		
		int a = 3;
		int b = 2;
		int c = 1;
		int d = 5;
		
		
		
		String[] character = phrase.split("");
		for(int i = 0; i < character.length; i++) {
			System.out.println(character[i]);
			
			// use char to convert to unicode - unadjusted
			char ch = phrase.charAt(i);
			int pos = ch;
//			System.out.println(pos);
			
		
			
			pos = pos + 32;
			
			System.out.println("CHAR 65 " + (char)65);
		
			
		}
		
		// converted to unicode
		int[] position = new int [character.length];
		
		for(int i= 0; i < position.length; i++) {
			position[i] = phrase.charAt(i);
			
			System.out.println("POS i " + position[i]);
			// convert letters to numbers by subtracting 32 0 - 94; largest symbol is 94
			position[i] = position[i] - 32;
			// add 32 back later
			
			
//			position[i] = ((position[i] - 32) % 126 - 32 + 1);
			
//			System.out.println(((position[i] - 32) % 126 - 32 + 1));
			
			// mod by 26
			System.out.println(position[i]);
				
		}
		
		// matrix multiplication
		// if even: block size 2
		// if odd: add 0 to end of the last block
		char[] encodedPhrase = new char [phrase.length()];
		
		
		int pos = 0;
		// use for inverse a, b, c, d
		// multiplication with a different matrix
		
		int[] matrixValue = new int [phrase.length()];
		// matrix multiplication
		if (phrase.length() % 2 == 0) {
			for (int i= 0; i < position.length; i = i+2) {
				encodedPhrase[i] = (char)((((a * position[i]) + (b * position[i+1])) % 95) + 32);
				encodedPhrase[i+1] = (char)((((c * position[i]) + (d * position[i+1])) % 95) + 32);
				
				matrixValue[i] = ((((a * position[i]) + (b * position[i+1])) % 95) + 32);
				matrixValue[i+1] = ((((c * position[i]) + (d * position[i+1])) % 95) + 32);

			}
		}
	
		System.out.println(Arrays.toString(encodedPhrase));
		System.out.println(Arrays.toString(matrixValue));
		
		// convert encodedPhrase array to be a string
		String encodedPhraseFinal = new String(encodedPhrase);
		System.out.println(encodedPhraseFinal);

		
		
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
		// denom ad - bc if multiple of 5 or 19 results in invalid
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
	
		
		
		
		
		return matrixValue;
		
		
		
		
		
		
	}
	
}
