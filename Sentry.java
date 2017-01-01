import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * takes a text file as an argument and creates new encrypted and decrypted text files
 * upon execution of the program. 
 */
public class Sentry {
	private Cipher cipher;

	public Sentry (Cipher cipher) {
		this.cipher = cipher;
	}

	public void encrypt(String inputFileName, String outputFileName) {
		// TODO Auto-generated method stub
		try {
			PrintWriter print = new PrintWriter(new File(outputFileName));
			Scanner keyboard = new Scanner(new File(inputFileName));
			encryptHelper(keyboard, print);
			print.close();
			keyboard.close();
		}
		catch (IOException e)  {
			System.err.println(e);
			System.exit(0);
		}
	}

	//helper method to create an encrypted text file for a specific cipher method
	private void encryptHelper(Scanner keyboard, PrintWriter print) {
		if (keyboard.hasNextLine()) {
			String temp = keyboard.nextLine();
			encryptHelper(keyboard, print);
			print.println(cipher.encrypt(temp));
		}
	}

	public void decrypt(String inputFileName, String outputFileName) {
		try {
			PrintWriter print = new PrintWriter(new File(outputFileName));
			Scanner keyboard = new Scanner(new File (inputFileName));
			decryptHelper(keyboard, print);
			print.close();
			keyboard.close();
		}
		catch (IOException e)  {
			System.err.println(e);
			System.exit(0);
		}
	}

	//helper method to decrypt the text
	private void decryptHelper(Scanner keyboard, PrintWriter print) {
		if (keyboard.hasNextLine()) {
			String temp = keyboard.nextLine();
			decryptHelper(keyboard, print);
			print.println(cipher.decrypt(temp));
		}
	}

	public static void main(String[] argv) {
		Sentry s = new Sentry(new CaesarCipher(3));

		s.encrypt("plaintext file", "encrypted");
		s.decrypt("encrypted", "decrypted");

	}

}
