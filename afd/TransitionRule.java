import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.ArrayList;

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
	public static ArrayList<TransitionRule> getFromFile(String filename){
		ArrayList<TransitionRule> lista = new ArrayList<TransitionRule>();
		TransitionRule nova;
		StringBuilder texto = new StringBuilder();
		String linha; String[] aux, regs;

		try {
			FileReader file = new FileReader(filename);
			BufferedReader br = new BufferedReader(file);

			linha = br.readLine();
			while (linha != null){
				linha = br.readLine();
				if(linha == null) break;
				texto.append(linha);
			}
			//System.out.println(texto.toString());
			br.close();

			linha = texto.toString().replaceAll(" |\t", "");
			linha = linha.substring(linha.indexOf("{")+1, linha.indexOf("}"));
			
			regs = linha.split(";");

			for (String r : regs){
				System.out.printf("Separando %s ...\n", r);
				aux = r.split(",");
				System.out.println(aux[0]);
				System.out.println(aux[1]);
				System.out.println(aux[2]);
				//# ERRO: a lista só adiciona o último objeto em todos os indices
				if (lista.isEmpty())
					lista.add(new TransitionRule(aux[0], aux[1].charAt(0), aux[2]));
				else
					lista.add(0, new TransitionRule(aux[0], aux[1].charAt(0), aux[2]));
			}

		} catch(IOException e){
			System.out.printf("Error: %s\n", e);
		}

		return lista;
	}//endOf getFromFile.
}