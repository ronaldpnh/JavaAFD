import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.List;

public class TransitionRule {

	protected static String ei;    //estado inicial
	protected static char simbolo; //simbolo a ser processado 
	protected static String ef;    //estado alvo

	/*Constructor: estado inicial (i), simbolo (s) e estado alvo (t)*/
	public TransitionRule(String i, char s, String t){
		this.ei = i;
		this.simbolo = s;
		this.ef = t;
	}

	//getters
	public String getInicial(){ return this.ei;}
	public char getSimbolo(){ return this.simbolo;}
	public String getAlvo(){ return this.ef;}


	/* Lê as regras escritas em um arquivo txt */
	public static String[][] getFromFile(String filename){
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
			System.out.printf("\nLendo regras de transição do arquivo...\n");
			System.out.println(texto.toString());
			br.close();
		} catch(IOException e){
			System.out.printf("Error: %s\n", e);
		}	


		/* Remove todos espaços em branco e tabulações, e pega somente o texto
		 * entre as chaves "{:::}"... Pega as partes separadas por ";" */
		linha = texto.toString().replaceAll(" |\t", "");
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

		return matriz;
	}
}									