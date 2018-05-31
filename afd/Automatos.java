import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
 * autor: Ronaldd Pinho
 * ronaldppinho@gmail.com
 */

public class Automatos {
	public static void main(String[] args) {
    	//Scanner in = new Scanner(System.in);
    	//String filename = args[0];
    	AFD automato = new AFD();

    	/* Criação do arquivo para leitura */
    	try {
    		FileReader arq = new FileReader(args[0]);
    		// Lê o arquivo atribui ao objeto
    		automato.readFromFile(arq);
    	} catch(IOException e) {
    		System.err.printf("%s\n", e);
    	}

    	automato.printAll();

    }
}