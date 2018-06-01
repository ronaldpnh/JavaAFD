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

        // args[0] == <arquivo.txt>
        // args[1] == <palavra>

        if (args.length == 2){

            AFD automato = new AFD();
    	    /* Criação do arquivo para leitura */
    	    try {
                FileReader arq = new FileReader(args[0]);
                
                automato.readFile(arq);      // Lê os parametros atribui ao objeto
                automato.getRules(args[0]); // Lê as regras de transição e atribui

            } catch(IOException e) {
                System.err.printf("%s\n", e);
            }

            //automato.printAll();    // Imprime todos os parametros 
            //automato.printRules(); // Imprime as regras de transição

            /*String estado = "qf";
            char simbolo = 'a';
            System.out.printf("Processamento:: (%s, %c) = %s\n", 
                estado, simbolo, automato.process(estado, simbolo));*/

            if(automato.startProcess(args[1]) == true) 
                System.out.println("\n"+automato.startProcess(args[1])+" -> Palavra ACEITA");
            else
                System.out.println("\n"+automato.startProcess(args[1])+" -> Palavra NÃO ACEITA");

        } else {
            System.err.println("Requer um arquivo txt e uma palavra pra processar.");
            System.err.printf("Tente: java Automato <nome-do-arquivo> <palavra>\n", args[0]);
        }
    }
}