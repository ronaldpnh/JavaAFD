# AFD.java
```
public class AFD()
```

## Methods

### ```printAll()```

Tipo de retorno: ```void```

Parâmetros:
```Sem parâmetros```

Imprime os parâmetros do Autômato Finito Determinístico na tela.

### ```readFile()```

Tipo de retorno: ```void```

Parâmetros:
```FileReader file```

Interpreta os dados de um arquivo txt e atribuir os valores as respectivas variaveis/vetores.

### ```getRules()```

Tipo de retorno: ```void```

Parâmetros:
```String filename```

Lê as regras escritas em um arquivo txt, recebe o nome do arquivo.

### ```printRule()```

Tipo de retorno: ```void```

Parâmetros:
```int index```

Imprime uma regra de transição , no indice indicados.

### ```printRules()```

Tipo de retorno: ```void```

Parâmetros:
```Sem parâmetros```

Imprime a lista de regras de transição.

### ```getFromFile()```

Tipo de retorno: ```void```

Parâmetros:
```String filename```

Lê as regras escritas em um arquivo txt, e preenche a lista de regras de transição.

### ```process()```

Tipo de retorno: ```String```

Parâmetros:
```String ei```
```char c```

Faz o processamento de um caractere. Recebe o estado inicial e um caractere, e retorna o estado final do processamento, se o estado não processa o caractere, retorna *null*.

### ```startProcess()```

Tipo de retorno: ```boolean```

Parâmetros:
```String palavra```

Recebe uma string e inicia o processamento caractere por caractere. Retorna **true** se a string é aceita a partir das regras de transição do objeto AFD que o chamou.

### ```startProcessState()```

Tipo de retorno: ```boolean```

Parâmetros:
```String curr```
```String palavra```

Método usado pelo startProcess() para processamento recursivo a partir do parâmetro estado inicial.
