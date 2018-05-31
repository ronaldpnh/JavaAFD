import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Teste {

	public static String[] estados;
	public static String[] simbolos;

	public static void main(String[] args){
		try {
			FileReader arq = new FileReader("exemplo.txt");
			importFromFILE(arq);

		} catch(IOException e){
			System.err.printf("Error: %s", e);
		}
	}

	public static void importFromFILE(FileReader file){
		try {
			BufferedReader br = new BufferedReader(file);

			String linha1 = br.readLine();
			System.out.printf("%s\n", linha1);

			linha1 = linha1.replaceAll("[()-]", "");
			System.out.printf("%s\n", linha1);

			String conjestado = linha1.substring(linha1.indexOf("{")+1, linha1.indexOf("}"));
			System.out.printf("Estados: %s\n", conjestado);
			estados = conjestado.split(",");
			for (String s : estados) System.out.printf("%s\n", s);


			br.close();// fecha a instancia do arquivo

		}catch(IOException e){
			System.err.printf("Erro: %s", e);
		}
	}
}