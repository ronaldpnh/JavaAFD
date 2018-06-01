import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Teste {
	public static void main(String[] args){

		String filename = args[0];
		AFD afd = new AFD();

		try {

			FileReader arq = new FileReader(filename);
			afd.readFile(arq);
			//afd.printAll();
			afd.getRules(filename);
			afd.printRules();

		} catch(IOException e){
			System.err.printf("Erro: %s\n", e);
		}
	}
}