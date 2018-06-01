import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
/* 
 * Estudo e tentativa de implementação de autômatos finitos determinísticos em Java
 * para a disciplina de Linguagens Formais, Autômatos e Computabilidade
 * curso de Ciência da Computação - Universidade Federal do Pará (UFPA) 
 * author: Ronaldd Pinho, em 31/05/2018
 * e-mail: ronaldppinho@gmail.com
 */

public class AFD {

	private static String[] estados;  // conjunto de estados
	private static char[] simbolos;   // conjunto de simbolos
	private static char regc;		  // caractere referente as reras de transição
	private static String[][] regras; // conjunto de regras de transição
	private static String einicial;   // estado inicial
	private static String[] efinais;  // conjunto de estados finais

	//public AFD(){}

	/*
	 * Imprime parâmetros do AFD na tela */
	public void printAll(){
		System.out.println("AFD:");

		System.out.printf("Conjunto de estados : { ");
		for (String s : estados)
			System.out.printf("%s ", s);
		System.out.println("}");

		System.out.printf("Conjunto de símbolos: { ");
		for (char c : simbolos)
			System.out.printf("%c ", c);
		System.out.println("}");

		System.out.printf("Regras de transição : %c\n", regc);
		System.out.printf("Estado inicial      : %s\n", einicial);
		System.out.printf("Estados finais      : { ");
		for (String s : efinais)
			System.out.printf("%s ", s);
		System.out.println("}\n");
	}

	//getters
	public String[] getEstados(){ return this.estados; }
	public char[] getSimbolos(){ return this. simbolos; }
	public char getRegChar(){ return this.regc; }
	public String[][] getRegras(){ return this.regras; }
	public String getEstadoInicial(){ return this.einicial; }
	public String[] getEstadosFinais(){ return this.efinais; }

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
		regc = linha1.toCharArray()[0];
		linha1 = linha1.replace(regc+",", "");

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
	}


	/* Usando um método da classe TransitionRule
	 * Lê as regras escritas em um arquivo txt, recebe o nome do arquivo */
	public static void getRules(String filename){
		regras = TransitionRule.getFromFile(filename);
	}

	/* Imprime uma regra de transição , no indice indicados*/
	public static void printRule(int index){
		System.out.printf("-- (%s, %s) -> %s\n", 
			regras[index][0], regras[index][1], regras[index][2]);
	}

	/* Imprime a lista de regras de transição */
	public static void printRules(){
		System.out.printf("Regras de transição: %c\n", regc);
		for (int i=0; i < regras.length; i++){
			System.out.printf("-- (%s, %s) -> %s\n", 
				regras[i][0], regras[i][1], regras[i][2]);
		}
	}


	/* Lê as regras escritas em um arquivo txt */
	public static void getFromFile(String filename){
		StringBuilder texto = new StringBuilder();
		String linha;
		String[] regs;
		String[][] matriz;

		try {
			FileReader file = new FileReader(filename);
			BufferedReader br = new BufferedReader(file);

			linha = br.readLine();
			while (linha != null){
				linha = br.readLine();
				if(linha == null) break;
				texto.append(linha);
			}
			System.out.printf("Lendo regras de transição do arquivo...\n");
			//System.out.println(texto.toString());
			br.close();
		} catch(IOException e){
			System.out.printf("Error: %s\n", e);
		}	

		/* Remove todos espaços em branco e tabulações, e pega somente o texto
		 * entre as chaves "{:::}"... Pega as partes separadas por ";" */
		linha = texto.toString().replaceAll(" |\t", "");
		System.out.println(linha);
		linha = linha.substring(linha.indexOf("{")+1, linha.indexOf("}"));
		regs = linha.split(";");

		/* Matriz armazenará as transições por linha, terá o numero de linhas
		 * igual ao tamanho do vetor regs[] */
		matriz = new String[regs.length][3];
			
		// Processo de separação e criação das regras, alocando na matriz
		for (int i=0; i<regs.length; i++){
			matriz[i] = regs[i].split(",");
			System.out.printf("Criando regra de transição [%s,%s,%s]...\n", 
				matriz[i][0], matriz[i][1], matriz[i][2]);
		}

		// Mostra as transições que foram criadas
		for (int i=0; i < regs.length; i++){
			System.out.printf("[%s, %s -> %s] Criado!\n", 
				matriz[i][0], matriz[i][1], matriz[i][2]);
		}

		regras = matriz;
	}


	/*
	 * Recebe o estado inicial e um caractere
	 * Retorna o estado final do processamento, se existir processamento */
	public static String process(String ei, char c){
		String target = "";
		return target;
	}


	/* Método recebe uma lista de regras de transição, uma string e
	 * retorna se a string é aceita a partir das regras de transição passadas */
	private static boolean startProcess(List<TransitionRule> regras, String palavra){
		return true;
	}

}