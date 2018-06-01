import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
/* 
 * Estudo e tentativa de implementação de autômatos finitos determinísticos em Java
 * para a disciplina de Linguagens Formais, Autômatos e Computabilidade
 * curso de Ciência da Computação - Universidade Federal do Pará (UFPA) 
 * author: Ronaldd Pinho, em 31/05/2018
 * e-mail: ronaldppinho@gmail.com
 */

public class AFD {

	private static String[] estados;
	private static char[] simbolos;
	private static char regtran;
	private static ArrayList<TransitionRule> regras;
	private static String einicial;
	private static String[] efinais;

	//public AFD(){}

	/*
	 * Imprime parâmetros do AFD na tela */
	public static void printAll(){
		System.out.println("AFD:");

		System.out.printf("Conjunto de estados : { ");
		for (String s : estados)
			System.out.printf("%s ", s);
		System.out.println("}");

		System.out.printf("Conjunto de símbolos: { ");
		for (char c : simbolos)
			System.out.printf("%c ", c);
		System.out.println("}");

		System.out.printf("Regras de transição : %c\n", regtran);
		System.out.printf("Estado inicial      : %s\n", einicial);
		System.out.printf("Estados finais      : { ");
		for (String s : efinais)
			System.out.printf("%s ", s);
		System.out.println("}");
	}


	/*
	 * Interpretar os dados de um arquivo txt e atribuir os valores as
	 * respectivas variaveis/vetores.
	 */
	public static void readFile(FileReader file){
		String linha="", linha1="", aux;

		try {
			BufferedReader br = new BufferedReader(file);
			linha = br.readLine(); //lê a primeira linha do arquivo
			linha1 = linha;
			br.close();
		} catch(IOException e){
			System.out.printf("Error: %s", e);
		}
		/* Remove os parenteses do inicio e fim da linha */
		linha1 = linha1.replaceAll("[()]","").replace(" ", "");

		/* Pegando o comjunto de estados:
		 * aux recebe uma substring delimitada por duas chaves '{ aux }' 
		 * posteriormente essa substring é separada e salva no vetor "estados" */
		aux = linha1.substring(linha1.indexOf("{")+1, linha1.indexOf("}"));
		estados = aux.split(",");
		/* Retira {aux}, da linha */
		linha1 = linha1.replaceAll(aux,"").replaceAll("\\{\\},","");

		/*
		 * Para "pegar" o conjunto de simbolos em um vetor de char[]
		 * Retira a substring entre as chaves correspondentes aos símbolos atribuindo a aux
		 * Retira as vigulas que separam os caracteres ...
		 * Transforma a string resultante em um vetor de char[]
		 */
		aux = linha1.substring(linha1.indexOf("{")+1, linha1.indexOf("}"));
		linha1 = linha1.replaceAll(aux,"").replaceAll("\\{\\},","");
		aux = aux.replace(",","");
		simbolos = aux.toCharArray();
		
		/* Pegando o caractere correspondente à regra de transição */
		regtran = linha1.toCharArray()[0];
		linha1 = linha1.replace(regtran+",", "");

		/* Pegando o estado inicial */
		einicial = linha1.substring(0, linha1.indexOf(","));
		linha1 = linha1.replace(einicial+",", "");

		/* Pegando o conjunto de estados finais
		 * Remove as '{}' se houver... Testa se a primeira letra da string é '{'*/
		if (linha1.startsWith("{"))
			aux = linha1.substring(linha1.indexOf("{")+1, linha1.indexOf("}"));
		else
			aux = linha1;
		linha1 = "";
		efinais = aux.split(",");
	}//endOf readFromFile()


	/* Usando um método da classe TransitionRule
	 * Lê as regras escritas em um arquivo txt, recebe o nome do arquivo */
	public static void getRules(String filename){
		regras = TransitionRule.getFromFile(filename);
	}


	/* Imprime a lista de regras de transição */
	public static void printRules(){
		System.out.printf("Regras de Transição: %c\n", regtran);
		for (TransitionRule r : regras){
			System.out.printf("- (%s, %c) = %s\n", r.getInicial(), r.getSimbolo(), r.getAlvo());
		}
	}


	/* Método recebe uma lista de regras de transição, uma string e
	 * retorna se a string é aceita a partir das regras de transição passadas */
	private static boolean startProcess(ArrayList<TransitionRule> regras, String palavra){
		return true;
	}

}