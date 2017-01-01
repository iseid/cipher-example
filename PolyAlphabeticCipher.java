
public class PolyAlphabeticCipher implements Cipher {

	//key that is responsible for encrypted character values
	private String key;

	public PolyAlphabeticCipher(String key) {
		this.key = key;
	}

	//encrypts a string via a key provided by the user
	@Override
	public String encrypt(String plaintext) {
		String encrypted = "";

		//ensures the key is the same length as the text we are trying to encrypt
		while(this.key.length() < plaintext.length()) {
			key += key;
		}

		/*optional to print the encryption key
		key = key .substring(0, ciphertext.length());
		System.out.println(key);
		 */

		for(int i=0; i<plaintext.length(); i++) {
			char c = plaintext.charAt(i);
			int keyvalue = ((int)key.charAt(i) - (int) 'A');
			c+=keyvalue;
			encrypted+=c;
		}
		return encrypted;
	}

	@Override
	public String decrypt(String ciphertext) {
		// TODO Auto-generated method stub
		String decrypted = "";

		while(this.key.length() < ciphertext.length()) {
			key += key;
		}

		/*optional to print the encryption key
		key = key .substring(0, ciphertext.length());
		System.out.println(key);
		 */

		for(int i=0; i<ciphertext.length(); i++) {
			char c = ciphertext.charAt(i);
			int keyvalue = ((int)key.charAt(i) - (int) 'A');
			c-=keyvalue;
			decrypted+=c;
		}
		return decrypted;
	}

	public static void main(String[] argv) {
		PolyAlphabeticCipher p = new PolyAlphabeticCipher("TESTKEY");
		String testString = "This text should be encrypted";
		String encryptedText = p.encrypt(testString);
		System.out.println("Original Text: " + testString);
		System.out.println("Encrypted Text: " + encryptedText);
		System.out.println("Decrypted Text: " + p.decrypt(encryptedText));
		if(!testString.equals(p.decrypt(encryptedText)))
			System.err.println("Error: Program is not correctly decrypting.");

	}
}
