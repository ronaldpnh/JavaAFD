import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
 * autor: Ronaldd Pinho
 * ronaldppinho@gmail.com
 */

public class Automato {
	public static void main(String[] args) {
        if (args.length > 0){
            AFD automato = new AFD();
    	    /* Criação do arquivo para leitura */
    	    try {
                FileReader arq = new FileReader(args[0]);
                // Lê o arquivo atribui ao objeto
                automato.readFile(arq);

            } catch(IOException e) {
                System.err.printf("%s\n", e);
            }

            automato.printAll();

        } else {
            System.out.println("Requer um arquivo txt.");
            System.out.println("Tente: java Automato <nome-do-arquivo>");
        }

    }
}