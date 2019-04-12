import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 *  * Copyright (c) 2019 Jourdan Parham
 *
 */

public class Encoding {
	/**
	 * @author Jourdan Parham
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter message: ");
		String phrase = sc.nextLine();
		
		System.out.println("Encode (E) or Decode (D)?");
		String encodeDecode = sc.nextLine();
		
		int a = 3;
		int b = 2;
		int c = 1;
		int d = 5;

		if (encodeDecode.equals("E")) {
			encode(phrase, a, b, c, d);
		}
	
		//---------------------------------------------------------------------------------------------
		
		int aInv = 15;
		int bInv = 51;
		int cInv = 73;
		int dInv = 66;

		
		if (encodeDecode.equals("D")) {
			int[] matrix = new int[phrase.length()];
			matrix = encode(phrase, a, b, c, d);
			System.out.println("The matrix: " + Arrays.toString(matrix));
			
			
			System.out.println("The updated matrix: " + Arrays.toString(matrix));

			int[] encodedPhrase = new int [phrase.length()];

			for (int i= 0; i < matrix.length; i = i+2) {
				encodedPhrase[i] = ((((aInv * matrix[i]) + (bInv * matrix[i+1])) % 95) + 32);
				encodedPhrase[i+1] = ((((cInv * matrix[i]) + (dInv * matrix[i+1])) % 95) + 32);
			}

			System.out.println("the encrypted message decoded in the main: " + Arrays.toString(encodedPhrase));

			char[] ch = new char[phrase.length()];
			String encodes = "";
		
			for(int i = 0; i < encodedPhrase.length; i++) {
				ch[i] = (char) encodedPhrase[i];
				encodes = new String(ch);
			}
			
			System.out.println("The encrypted message [" + "] is now decoded: " + encodes);
			
		}
		
	
}
	// DECODE----------------------------------------------------------------------------------------------------------
	public static int[][] decode(String phrase, int a, int b, int c, int d) {		
		a = 3;
		b = 2;
		c = 1;
		d = 5;
//		
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
			
			
			if (ans % mod == 1) {
				inverse = i;
				inverse = inverse % mod;
//				System.out.println("Inverse: " + inverse);
//				System.out.println();
				
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
				decodeMatrix[i][j] = (decodeMatrix[i][j] * inverse  % mod + mod) % mod;
				// if statement to store new a, b, c, d values for the decoding matrix
				System.out.print(decodeMatrix[i][j]);
			}
			System.out.println();
			
		}
		return decodeMatrix;
		
		
	}
	
	// ENCODING ------------------------------------------------------------------------------------------------------------------
	
	public static int[] encode(String phrase, int a, int b, int c, int d) {
		
		
		
		
		String[] character = phrase.split("");
		for(int i = 0; i < character.length; i++) {
//			System.out.println(character[i]);
			
			// use char to convert to unicode - unadjusted
			char ch = phrase.charAt(i);
			int pos = ch;
			
			pos = pos + 32;

			
		}
		
		// converted to unicode
		int[] position = new int [character.length];
		
		for(int i= 0; i < position.length; i++) {
			position[i] = phrase.charAt(i);
			
			System.out.println("POS i " + position[i]);
			// convert letters to numbers by subtracting 32 0 - 94; largest symbol is 94
			position[i] = position[i] - 32;
			System.out.println(position[i]);
			// add 32 back later	
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
				
				matrixValue[i] = ((((a * position[i]) + (b * position[i+1])) % 95));
				matrixValue[i+1] = ((((c * position[i]) + (d * position[i+1])) % 95));

			}
		}
	
		// Prints the coded phrase
//		System.out.println(Arrays.toString(encodedPhrase));
		
		// Prints the position of the coded phrase
//		System.out.println(Arrays.toString(matrixValue));
		
		// convert encodedPhrase array to be a string
		String encodedPhraseFinal = new String(encodedPhrase);
		System.out.println("Your message  [" + phrase + "] is now encoded: " + encodedPhraseFinal);

		
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
		
		return matrixValue;

		
	}
	
}
