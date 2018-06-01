# JavaAFD                                                                       
## Autômatos Finitos Determinísticos em Java                                   
                                                                                
Para compilar e executar, no diretótio dos arquivos, digite:                    
                                                                                
```javac Automato.java```                                                       
                                                                                
```java Automato [nome-do-arquivo] [palavra]```                                 
                                                                                
Sendo [nome-do-arquivo] um arquivo txt com a definição do autômato e [palavra]  
a palavra que se deseja processar.                                              
                                                                                
Exemplo com um dos arquivos já existentes:                                      
                                                                                
``` java Automato exemplo.txt aabab```                                            
                                                                                
                                                                                
## Arquivo .txt                                                                 
                                                                                
### O arquivo txt deve seguir o seguinte padrão de definição:                       
                                                                                
A primeira linha é a definição da 5-tupla (quíntupla), que deve ser um par de parênteses contendo os parâmetros separados por vírgula na seguinte ordem:

1. Conjunto de estados possíveis, Entre chaves. { }
2. Conjunto de símbolos (alfabeto). Entre chaves. { }
3. Caractere referente ao conjunto regras de transição.
4. Estado inicial.
5 Conjunto de estados finais. Entre chaves. { } A não ser que seja um único estado final.

Nas linhas abaixo, a definição das regras de transição.

- Devem estar entre chaves e separadas por ponto-e-vígula (;).

- Uma egra é compsta por estado inicial, simbolo e estado-alvo, todos devem estar separados por vírgula (,)

- Exemplo de arquivo:

```
({q0, q1, q2, qf}, {a, b}, T, q0, qf)

T: {
	q0, a, q1;
	q0, b, q2;
	q1, a, qf;
	q1, b, q2;
	q2, a, q1;
	q2, b, qf;
	qf, a, qf;
	qf, b, qf;
}
```
