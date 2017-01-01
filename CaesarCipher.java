
public class CaesarCipher implements Cipher {

	//keeps track of character shift from the caesar cipher
	private int numberOfPositions;

	public CaesarCipher(int numberOfPositions) {
		if(numberOfPositions > 0) {
			this.numberOfPositions = numberOfPositions;
		}
	}

	//encrypts text by modifying the characters value to a specified amount
	//which is represented by numberOfPositions.
	//NOTE: white space in strings is not modified
	@Override
	public String encrypt(String plaintext) {
		String encrypted="";

		for(int i=0;i<plaintext.length();i++) {
			int c=plaintext.charAt(i);

			if(Character.isUpperCase(c)) {
				c=c+(this.numberOfPositions%26);

				if(c>'Z') {
					c-=26;
				}
			}

			else if(Character.isLowerCase(c)) {
				c=c+(this.numberOfPositions%26);

				if(c>'z') {
					c-=26;
				}
			}

			encrypted+=(char) c;
		}
		return encrypted;
	}

	//decrypt shifts the encrypted text back to the original text
	@Override
	public String decrypt(String ciphertext) {
		String decrypted="";
		for(int i=0;i<ciphertext.length();i++) {
			int c=ciphertext.charAt(i);

			if(Character.isUpperCase(c)) {
				c=c-(this.numberOfPositions%26);

				if(c<'A') {
					c=c+26;
				}
			}

			else if(Character.isLowerCase(c)) {
				c=c-(this.numberOfPositions%26);

				if(c<'a') {
					c=c+26;
				}
			}

			decrypted+=(char) c;
		}
		return decrypted;
	}

	public static void main(String[] argv) {
		CaesarCipher cipher = new CaesarCipher(3);
		String testString = "Example String WITH RanDom ChArAcTER values.";
		System.out.println("Original Text: " + testString);
		String cipherText = cipher.encrypt(testString);
		System.out.println("After encryption: " + cipherText);
		String decryptText = cipher.decrypt(cipherText);
		System.out.println("After decryption: " + decryptText);
		if(!testString.equals(decryptText))
			System.err.println("Error: Program is not correctly decrypting.");

		System.out.println();
		String s = "xY z";
		System.out.println(s);
		System.out.println(cipher.encrypt(s));
		System.out.println(cipher.decrypt(s));
	}

}

